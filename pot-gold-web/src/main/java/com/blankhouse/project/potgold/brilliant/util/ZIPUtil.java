package com.blankhouse.project.potgold.brilliant.util;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

/**
 * @author hujia
 * @date 8/25/19
 * @since 1.0.0
 */
public class ZIPUtil {

    public static File zip(File file) throws IOException {

        File f2 = null;
        if(file.getName().endsWith(".jpg")){
            f2= new File(file.getAbsolutePath().replaceFirst("tempPic", "zipdPic"));
        }else {
            f2 = new File(file.getAbsolutePath().replaceFirst("tempPic", "zipdPic") + ".jpg");
        }

        File parentFile = f2.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }

        Thumbnails.of(file)
                .size(2048, 2048)
                .outputQuality(1f)
                .outputFormat("jpg")
                .toFile(f2);

        System.out.println(file.length());

        return f2;

    }

    public static void main(String[] args) throws IOException {
       zip(new File("/Users/harlan/b/life/menglu/temp.png"));
    }
}
