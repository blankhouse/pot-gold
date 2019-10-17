package com.blankhouse.project.potgold.brilliant.util;

import com.blankhouse.project.potgold.common.bean.DebugException;
import com.blankhouse.project.potgold.model.TGoldTask;
import com.itextpdf.text.pdf.PdfReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * @author hujia
 * @date 30/9/2019
 * @since 1.0.0
 */
public class OcrUtil {


    /**
     * 返回路径
     *
     * @param file
     * @param countDown1
     * @param id
     * @return
     */
    public static void pdf2Image(final String PdfFilePath, final String dstImgFolder, final int dpi, ExecutorService fixedThreadPool, CountDownLatch countDown1, Long id) throws DebugException {
        final File file = new File(PdfFilePath);


        if (file.isDirectory()) {
            for (File f1 : file.listFiles()) {
                pdf2Image(f1.getAbsolutePath(), dstImgFolder + "/" + file.getName(), dpi, fixedThreadPool, countDown1, id);
            }
        } else {
            if (!file.getName().endsWith(".pdf")) {
                return;
            }

            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    PDDocument pdDocument = null;
                    try {
                        String imgPDFPath = file.getParent();
                        int dot = file.getName().lastIndexOf('.');
                        String imagePDFName = file.getName().substring(0, dot); // 获取图片文件名
                        String imgFolderPath = null;
                        if (dstImgFolder.equals("")) {
                            imgFolderPath = imgPDFPath + File.separator + imagePDFName;// 获取图片存放的文件夹路径
                        } else {
                            imgFolderPath = dstImgFolder + File.separator + imagePDFName;
                        }

                        if (createDirectory(imgFolderPath)) {

                            pdDocument = PDDocument.load(file);
                            PDFRenderer renderer = new PDFRenderer(pdDocument);
                            /* dpi越大转换后越清晰，相对转换速度越慢 */
                            PdfReader reader = new PdfReader(PdfFilePath);
                            int pages = reader.getNumberOfPages();
                            TGoldTask tGoldTask = new TGoldTask();
                            tGoldTask.setTotal((long) pages);
                            tGoldTask.setId(id);
                            MapperUtil.updateById(tGoldTask);
                            StringBuffer imgFilePath = null;
                            for (long i = 0; i < pages; i++) {
                                String imgFilePathPrefix = imgFolderPath + File.separator + imagePDFName;
                                imgFilePath = new StringBuffer();
                                imgFilePath.append(imgFilePathPrefix);
                                imgFilePath.append("_");
                                imgFilePath.append(String.valueOf(i + 1));
                                imgFilePath.append(".png");
                                File dstFile = new File(imgFilePath.toString());
                                BufferedImage image = renderer.renderImageWithDPI((int)i, dpi);
                                ImageIO.write(image, "png", dstFile);
                                if (i % 10 == 0 || i == pages - 1) {
                                    TGoldTask tGoldTask2 = new TGoldTask();
                                    tGoldTask2.setConverted(i + 1);
                                    tGoldTask2.setId(id);
                                    MapperUtil.updateById(tGoldTask2);
                                }
                            }
                            System.out.println("PDF文档转PNG图片成功！");

                        } else {
                            System.out.println("PDF文档转PNG图片失败：" + "创建" + imgFolderPath + "失败");
                        }

                    } catch (Throwable e) {
                        e.printStackTrace();
                    } finally {
                        countDown1.countDown();
                    }
                }
            });


        }
    }

    private static boolean createDirectory(String folder) {
        File dir = new File(folder);
        if (dir.exists()) {
            return true;
        } else {
            return dir.mkdirs();
        }
    }
}
