package com.zcckj.esign.client;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import com.zcckj.common.mvc.result.Result;
import com.zcckj.esign.client.interceptor.RequestInterceptor;
import com.zcckj.esign.dto.req.GetFileUploadUrlReq;
import com.zcckj.esign.dto.res.GetFileUploadUrlRes;
import retrofit2.http.Body;
import retrofit2.http.POST;


@RetrofitClient(baseUrl = "${esign.base-url}")
@Intercept(handler = RequestInterceptor.class)
public interface FileClient {
    /**
     * 获取文件上传地址
     * @param req
     * @return
     */
    @POST("/v3/files/file-upload-url")
    Result<GetFileUploadUrlRes> getFileUploadUrl(@Body GetFileUploadUrlReq req);

}
