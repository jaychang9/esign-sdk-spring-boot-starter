package com.zcckj.esign.client;

import com.zcckj.esign.constant.ESignConstant;
import com.zcckj.esign.support.FileMd5Helper;
import lombok.experimental.UtilityClass;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 文件上传
 * @author zhangjie
 */
@UtilityClass
public class FileUploadClient {

    /**
     * @param mediaType MediaType
     * @param uploadUrl put请求地址
     * @param filePath  本地文件路径
     * @return 响应的结果 和 HTTP status code
     * @throws IOException
     */
    public String upload(MediaType mediaType, String uploadUrl, String filePath) throws IOException {
        File file = new File(filePath);
        return upload(mediaType, uploadUrl, file);
    }

    /**
     * @param mediaType MediaType
     * @param uploadUrl put请求地址
     * @param localPath 本地文件路径
     * @return 响应的结果 和 HTTP status code
     * @throws IOException
     */
    public String upload(MediaType mediaType, String uploadUrl, File file) throws IOException {
        RequestBody body = RequestBody.create(mediaType, file);
        Request request = new Request.Builder()
                .url(uploadUrl)
                .addHeader(ESignConstant.CONTENT_MD5_HEADER_NAME, FileMd5Helper.getFileContentMD5(file))
                .put(body)
                .build();

        //修改各种 Timeout
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
        //如果不需要可以直接写成 OkHttpClient client = new OkHttpClient.Builder().build();

        Response response = client
                .newCall(request)
                .execute();
        return response.body().string() + ":" + response.code();
    }
}
