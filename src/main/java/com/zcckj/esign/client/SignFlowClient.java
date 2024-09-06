package com.zcckj.esign.client;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import com.zcckj.common.mvc.result.Result;
import com.zcckj.esign.client.interceptor.ESignRequestInterceptor;
import com.zcckj.esign.dto.req.CreateByFileReq;
import com.zcckj.esign.dto.res.CreateByFileRes;
import retrofit2.http.POST;

/**
 * 签署类
 */
@RetrofitClient(baseUrl = "${esign.base-url}")
@Intercept(handler = ESignRequestInterceptor.class)
public interface SignFlowClient {

    /**
     * （精简版）基于文件发起签署
     * @param req
     * @return
     */
    @POST("/v3/sign-flow/create-by-file")
    Result<CreateByFileRes> createByFile(CreateByFileReq req);
}
