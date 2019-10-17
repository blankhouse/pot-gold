package com.blankhouse.project.potgold.brilliant.baidu;

import com.blankhouse.project.potgold.brilliant.util.Base64Util;
import com.blankhouse.project.potgold.brilliant.util.FileUtil;
import com.blankhouse.project.potgold.brilliant.util.HttpUtil;
import com.blankhouse.project.potgold.brilliant.util.MapperUtil;
import com.blankhouse.project.potgold.brilliant.util.ZIPUtil;
import com.blankhouse.project.potgold.common.bean.ResultVO;
import com.blankhouse.project.potgold.common.bean.Word;
import com.blankhouse.project.potgold.model.TGoldTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author hujia
 * @date 8/10/2019
 * @since 1.0.0
 */
public class OcrBean {

    public OcrBean(String workPath, ExecutorService executorService, CountDownLatch secondLatch, Long id) {
        this.executorService = executorService;
        continuePath = workPath;
        tempImgPath = workPath + "/tempPic";
        outputPath = workPath + "/output";
        count = new AtomicLong(0);
        dbId = id;
        countDownLatch = secondLatch;
    }


    private String continuePath = "/Users/harlan/b/life/menglu/continue";

    private String tempImgPath = "/Users/harlan/b/life/menglu/tempPic";

    private String outputPath = continuePath + "/output";

    private final static Word words = new Word();

    private String recordPath = "";

    private CountDownLatch countDownLatch;

    private static boolean endflag = false;

    private ExecutorService executorService;

    private Long dbId;

    final static String client_id = "3ttsOQGRDFuUcokszQRfQwZD";
    final static String client_secret = "ZeeNCbKNq7NWQnefUSiGADdyI4CO9CLY";

    private AtomicLong count;

    final static Gson gson = new GsonBuilder().create();

    // 一月过期
    private static String tokenStr = "24.7996258e814996cb64a188a36786ad7f.2592000.1573138299.282335-15468285";


    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public static final MediaType JSON2
            = MediaType.get("application/x-www-form-urlencoded; charset=utf-8");

    static OkHttpClient client = new OkHttpClient();

    static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * 支持断点续传
     *
     * @param args
     */
    public void run(String[] args) {
        recordPath = FileUtil.readRecord(this.continuePath).split("\\|\\|")[0];
        handleFile(new File(tempImgPath), new File(outputPath));
    }

    public void handleFile(final File file, final File out) {

        // 如果小
        if (comparePath(file.getAbsolutePath(), this.recordPath)) {
            if(file.isFile() && file.getAbsolutePath().endsWith(".png")){
                count.addAndGet(1);
                countDownLatch.countDown();
            }
            return;
        }


        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                Arrays.sort(list);
                for (String f : list) {
                    handleFile(new File(file, f), new File(out, file.getName()));
                }
            }
        } else {
            String name = file.getName();
            if (name.endsWith(".tif") || name.endsWith(".TIF") || name.endsWith(".png") || name.endsWith(".jpg") || name.endsWith(".jpeg")) {
                // 记录遍历过的数据

                System.out.println(file.getAbsolutePath());
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            assertImgContainWords(file.getAbsolutePath(), words, out);
                            TGoldTask tGoldTask = new TGoldTask();
                            tGoldTask.setId(dbId);
                            tGoldTask.setCurrent(count.get());
                            MapperUtil.updateById(tGoldTask);
                        }finally {
                            countDownLatch.countDown();
                        }
                    }
                });


            }

            if (name.endsWith(".pdf")) {

            }

        }
    }

    private static boolean comparePath(String absolutePath, String recordPath) {

        if (endflag) {
            return false;
        }

        // 没遍历过的 返回false ， 遍历了的，返回true
        if (absolutePath == null || recordPath == null) {
            return false;
        }

        if (recordPath.contains(absolutePath)) {
            return false;
        }

        int i = absolutePath.compareTo(recordPath);
        if (i < 0) {
            // 遍历过
            return true;
        } else {
            // 没
            endflag = true;
            return false;
        }
    }


    public boolean assertImgContainWords(String filePath, Word word, File out) {


        try {

            String filePath2 = filePath;
            File file = new File(filePath);
            if (file.length() > 1500000) {
                System.out.println("进行压缩");
                file = ZIPUtil.zip(file);
                filePath2 = file.getPath();
                if (new File(filePath2).length() > 4000000) {
                    System.out.println("---------------------jpg too big------------" + filePath2);
                    return false;
                }
            } else {
                file = null;
            }


            List<ResultVO.WordsResultBean> wordsResult = requestBaidu(filePath2);
            String contine = isContine(wordsResult, word);
            if (contine != null && contine.length() > 0) {
                FileUtil.log(this.continuePath, filePath.concat("\t").concat(contine));
                FileUtil.record(this.continuePath, filePath);
                doCopy(new File(filePath), out);
                System.out.println("找到了1处");
                return true;
            }

            FileUtil.record(this.continuePath, filePath);
        } catch (Exception e) {
            System.out.println("错误图片地址" + filePath);
            throw new RuntimeException(e);
        }
        return false;
    }

    public static String isContine(List<ResultVO.WordsResultBean> wordsResult, Word word) {

        StringBuilder sb = new StringBuilder();

        for (ResultVO.WordsResultBean bean : wordsResult) {
            String str = bean.getWords();
            for (String s : word.getcWords()) {
                if (str.contains(s)) {
                    sb.append(str).append("....");
                }
            }
            for (String s : word.getStartWords()) {
                if (str.startsWith(s)) {
                    sb.append(str).append("....");
                }
            }
            for (String s : word.getEndWords()) {
                if (str.endsWith(s)) {
                    sb.append(str).append("....");
                }
            }

        }
        return sb.toString();
    }

    public static void doCopy(File file, File out) {
        try {

            if (!out.exists()) {
                out.mkdirs();
            }


            // 创建文件输出的字节流，用于将读取到的问件内容写到另一个磁盘文件中，目标文件
            FileOutputStream os = new FileOutputStream(new File(out, file.getName()));

            // 创建字符串，用于缓冲

            Files.copy(file.toPath(), os);

            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ResultVO.WordsResultBean> requestBaidu(String filePath) throws Exception {

        String result = null;
        try {

            System.out.println("即将请求baidu" + "  " + filePath);
            // 通用识别url
            String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            String accessToken = tokenStr;
            long st = System.currentTimeMillis();
            result = HttpUtil.post(otherHost, accessToken, params);
            long end = System.currentTimeMillis();
            long time = end - st;
            System.out.println(result);
            System.out.println("time " + time + " ms");

            System.out.println(count.addAndGet(1));
            ResultVO resultVO = gson.fromJson(result, ResultVO.class);

            if (filePath.contains("zipdPic")) {
                new File(filePath).delete();
            }

            System.out.println("baidu处理结束" + "  " + filePath);

            if (resultVO.getWordsResult() != null) {
                return resultVO.getWordsResult();
            }
        } catch (NullPointerException e) {
            System.out.println(result);
            e.printStackTrace();

        }
        return Collections.emptyList();
    }
}
