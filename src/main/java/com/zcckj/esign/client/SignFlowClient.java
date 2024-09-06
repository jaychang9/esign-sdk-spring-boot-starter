package com.zcckj.esign.client;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import com.zcckj.common.mvc.result.Result;
import com.zcckj.esign.client.interceptor.ESignRequestInterceptor;
import com.zcckj.esign.dto.req.CreateByFileReq;
import com.zcckj.esign.dto.req.CreateByFileSimpleReq;
import com.zcckj.esign.dto.req.GetSignUrlReq;
import com.zcckj.esign.dto.res.CreateByFileRes;
import com.zcckj.esign.dto.res.GetSignUrlRes;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 签署类
 *
 * @author zhangjie
 */
@RetrofitClient(baseUrl = "${esign.base-url}")
@Intercept(handler = ESignRequestInterceptor.class)
public interface SignFlowClient {

    /**
     * （精简版）基于文件发起签署
     *
     * @param req
     * @return
     */
    @POST("/v3/sign-flow/create-by-file")
    Result<CreateByFileRes> createByFile(@Body CreateByFileSimpleReq req);


    /**
     * （完整版）基于文件发起签署
     *
     * @param req
     * @return
     */
    @POST("/v3/sign-flow/create-by-file")
    Result<CreateByFileRes> createByFile(@Body CreateByFileReq req);

    /**
     * 获取签署页面链接
     *
     * @param req
     * @return
     */
    @POST("/v3/sign-flow/{signFlowId}/sign-url")
    Result<GetSignUrlRes> getSignUrl(@Path("signFlowId") String signFlowId, @Body GetSignUrlReq req);
}
