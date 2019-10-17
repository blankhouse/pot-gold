package com.blankhouse.project.potgold.service;

import com.blankhouse.project.potgold.brilliant.baidu.OcrBean;
import com.blankhouse.project.potgold.brilliant.util.MapperUtil;
import com.blankhouse.project.potgold.brilliant.util.OcrUtil;
import com.blankhouse.project.potgold.common.bean.BizException;
import com.blankhouse.project.potgold.common.bean.DebugException;
import com.blankhouse.project.potgold.enums.ENUMS;
import com.blankhouse.project.potgold.mapper.TGoldTaskMapper;
import com.blankhouse.project.potgold.model.TGoldTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hujia
 * @date 8/10/2019
 * @since 1.0.0
 */
@Service
public class OcrService {

    @Autowired
    private TGoldTaskMapper tGoldTaskMapper;

    private final static String OCR_PATH = "/data1/ocr";

    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);


    public File downLoad(Long taskId) throws IOException, InterruptedException, BizException {
        //return new File("/Users/harlan/Downloads/PMBOK电子书--中英文版/手机适配版/01第一部分：第1章.pdf");
        TGoldTask tGoldTask = MapperUtil.findById(taskId);

        if (!ENUMS.OcrProce.SUCCESS.getValue().equals(tGoldTask.getStep())) {
            throw new BizException("file not ready");
        }
        String fileOrigin = tGoldTask.getFileOrigin();
        //tar -zcf result.zip output/ log.txt
        //String model = "tar -zcPf result.zip {0}/output/ {0}/log.txt";
        String model = "sh {0}/mybash.sh {1}";
        String bashCommand = MessageFormat.format(model, OCR_PATH, new File(fileOrigin).getName());
        System.out.println(bashCommand);
        Runtime runtime = Runtime.getRuntime();
        Process pro = runtime.exec(bashCommand);
        int status = pro.waitFor();
        if (status != 0) {
            throw new RuntimeException("Failed to call shell's command ");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
        StringBuffer strbr = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            strbr.append(line).append("\n");
        }

        String result = strbr.toString();
        System.out.println(result);
        return new File(fileOrigin + "/result.zip");
    }

    /**
     * 1. pdf-> png
     * 2. png-> ocr ->zip
     * 3. return
     * <p>
     * 提供下载列表,然后可以继续,重新开始
     * <p>
     * 异常重试,与处理机制
     * 1. pdf 转文件失败, 结束判定
     * 2. ocr 网络异常与重试机制,多线程,监听一个异常出现的频率
     * 3. 循环完成后的处理
     * <p>
     * 主线程退出会影响任务执行
     *
     * @param file
     * @return
     */
    public File testHandle(File file, Long retryId) throws InterruptedException {

        TGoldTask tGoldTask = null;
        if (retryId != null) {
            tGoldTask = MapperUtil.findById(retryId);
        }
        if (tGoldTask == null) {
            tGoldTask = initTask(file.getName());
        }

        asyncHandle(file, tGoldTask.getId());
        return null;
    }

    public File handle(MultipartFile multipartFile, Long retryId) throws InterruptedException {

        TGoldTask tGoldTask = null;
        if (retryId != null) {
            tGoldTask = MapperUtil.findById(retryId);
        }
        File file = null;
        if (tGoldTask == null) {
            tGoldTask = initTask(multipartFile.getOriginalFilename());
            byte[] bytes = new byte[0];
            try {
                bytes = multipartFile.getBytes();
                String filePath = tGoldTask.getFileOrigin() + "/origin/" + multipartFile.getOriginalFilename();
                Path path = Paths.get(filePath);
                new File(tGoldTask.getFileOrigin() + "/origin/").mkdirs();
                Files.write(path, bytes);
                file = new File(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (file == null) {
                throw new RuntimeException("file copy fail");
            }
        }



        Long id = tGoldTask.getId();

        File finalFile = file;
        fixedThreadPool.execute(() -> {
            try {
                doHandle(finalFile, id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return null;
    }

    private void asyncHandle(File file, Long retryId) throws InterruptedException {
        CountDownLatch out = new CountDownLatch(1);
        fixedThreadPool.execute(() -> {
            try {
                doHandle(file, retryId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                out.countDown();
            }
        });
        out.await();
    }

    public File doHandle(File file, Long retryId) throws InterruptedException {

        TGoldTask tGoldTask = MapperUtil.findById(retryId);

        System.out.println(tGoldTask);
        // 转pdf
        if (ENUMS.OcrProce.TRANSFER.getValue() >= tGoldTask.getStep()) {
            CountDownLatch countDown1 = new CountDownLatch(1);
            try {
                OcrUtil.pdf2Image(file.getAbsolutePath(), tGoldTask.getFileOrigin() + "/tempPic", 350, fixedThreadPool, countDown1, tGoldTask.getId());
            } catch (DebugException e) {
                // 记录失败原因
                e.printStackTrace();
                TGoldTask tGoldTask1 = new TGoldTask();
                tGoldTask1.setId(retryId);
                tGoldTask1.setException("error" + e.getMessage());
                MapperUtil.updateById(tGoldTask1);
                return null;
            }
            countDown1.await();

            TGoldTask tGoldTask2 = new TGoldTask();
            tGoldTask2.setId(retryId);
            tGoldTask2.setStep(ENUMS.OcrProce.UPLOAD.getValue());
            MapperUtil.updateById(tGoldTask2);
        }


        TGoldTask second = MapperUtil.findById(tGoldTask.getId());
        Long total = second.getTotal();
        CountDownLatch secondLatch = new CountDownLatch(total.intValue());


        OcrBean ocrBean = new OcrBean(tGoldTask.getFileOrigin(), fixedThreadPool, secondLatch, tGoldTask.getId());
        // 图片识别
        ocrBean.run(null);
        secondLatch.await();
        TGoldTask end = new TGoldTask();
        end.setId(tGoldTask.getId());
        end.setStep(ENUMS.OcrProce.SUCCESS.getValue());
        MapperUtil.updateById(end);
        return null;
    }


    private TGoldTask initTask(String originFileName) {
        TGoldTask tGoldTask;
        tGoldTask = new TGoldTask();
        tGoldTask.setCreateBy(2L);
        tGoldTaskMapper.insertSelective(tGoldTask);
        String id = tGoldTask.getId().toString();
        String fileOrigin = OCR_PATH + "/" + id + "-" + originFileName.replace(".pdf", "");
        System.out.println(fileOrigin);
        tGoldTask.setFileOrigin(fileOrigin);
        tGoldTask.setStep(ENUMS.OcrProce.TRANSFER.getValue());
        MapperUtil.updateById(tGoldTask);
        return tGoldTask;
    }
}
