package com.blankhouse.project.potgold.brilliant.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/**
 * 文件读取工具类
 */
public class FileUtil {

    /**
     * 读取文件内容，作为字符串返回
     */
    public static String readFileAsString(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        }

        if (file.length() > 1024 * 1024 * 1024) {
            throw new IOException("File is too large");
        }

        StringBuilder sb = new StringBuilder((int) (file.length()));
        // 创建字节输入流  
        FileInputStream fis = new FileInputStream(filePath);
        // 创建一个长度为10240的Buffer
        byte[] bbuf = new byte[10240];
        // 用于保存实际读取的字节数  
        int hasRead = 0;
        while ((hasRead = fis.read(bbuf)) > 0) {
            sb.append(new String(bbuf, 0, hasRead));
        }
        fis.close();
        return sb.toString();
    }

    /**
     * 根据文件路径读取byte[] 数组
     */
    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }

                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                bos.close();
            }
        }
    }

    public static String readRecord(String path) {
        try {
            return readFileAsString(path + "/record.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void log(String path, String word) {
        synchronized (path) {
            log(word, new File(path + "/log.txt"), true);
        }
    }

    public static void record(String path, String word) {
        synchronized (path) {
            log(word, new File(path + "/record.txt"), false);
        }
    }

    public static void log(String word, File file, boolean append) {
        try {
            if (!file.exists()) {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            }

            try (OutputStream output = new FileOutputStream(file, append)) {
                output.write(word.concat("||\t").concat(new Date().toLocaleString()).concat("\n").getBytes("utf-8"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

//        System.out.println("start");
//        File file = new File("/b/life/menglu/test/xixi.text");
//
//        String parent = file.getParent();
//        new File(parent).mkdirs();
//        OutputStream output = new FileOutputStream(file);
//
//        BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
//
//        byte[] byt = "heehh".getBytes();
//
//        bufferedOutput.write(byt);
//        bufferedOutput.close();


//        log("hehe", new File("/b/life/menglu/test/xi.txt"), true);
//        log("first");
//        record("first");
        //System.out.println(readRecord());
        System.out.println(new Integer(1).compareTo(new Integer(2)));
        System.out.println("ab".compareTo("abcccc"));
    }
}
