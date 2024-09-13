package com.zcckj.esign.support;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Slf4j
@UtilityClass
public class FileMd5Helper {


    /***
     * 计算文件的Content-MD5
     * @param file 文件路径
     * @return
     */
    public String getFileContentMD5(File file) {
        // 获取文件MD5的二进制数组（128位）
        try {
            byte[] bytes = getFileMD5Bytes128(new FileInputStream(file));
            // 对文件MD5的二进制数组进行base64编码
            return new String(Base64.encodeBase64(bytes));
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
            return "";
        }
    }

    /***
     * 计算文件的Content-MD5
     * @param filePath 文件路径
     * @return
     */
    public String getFileContentMD5(String filePath) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            // 获取文件MD5的二进制数组（128位）
            byte[] bytes = getFileMD5Bytes128(fis);
            // 对文件MD5的二进制数组进行base64编码
            return new String(Base64.encodeBase64(bytes));
        } catch (FileNotFoundException fe) {
            log.error("file not found", fe);
        }
        return "";
    }


    /***
     * 计算文件的Content-MD5
     * @param bytes 字节数组
     * @return
     */
    public String getFileContentMD5(byte[] bytes) {
        // 获取文件MD5的二进制数组（128位）
        return new String(Base64.encodeBase64(bytes));
    }

    /***
     * 获取文件MD5-二进制数组（128位）
     *
     * @param ins 输入流
     * @return
     * @throws IOException
     */
    public byte[] getFileMD5Bytes128(InputStream ins) {
        byte[] md5Bytes = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = ins.read(buffer, 0, 1024)) != -1) {
                md5.update(buffer, 0, length);
            }
            md5Bytes = md5.digest();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(ins)) {
                try {
                    ins.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return md5Bytes;
    }

}
