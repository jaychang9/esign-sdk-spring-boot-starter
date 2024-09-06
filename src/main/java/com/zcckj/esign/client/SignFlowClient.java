package com.zcckj.esign.client;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import com.zcckj.common.mvc.result.Result;
import com.zcckj.esign.client.interceptor.ESignRequestInterceptor;
import com.zcckj.esign.dto.req.*;
import com.zcckj.esign.dto.res.CreateByFileRes;
import com.zcckj.esign.dto.res.GetBatchSignUrlRes;
import com.zcckj.esign.dto.res.GetSignFlowDetailRes;
import com.zcckj.esign.dto.res.GetSignUrlRes;
import retrofit2.http.Body;
import retrofit2.http.GET;
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


    /**
     * 获取签署页面链接
     *
     * @return
     */
    @POST("/v3/sign-flow/batch-sign-url")
    Result<GetBatchSignUrlRes> getBatchSignUrl(@Body GetBatchSignUrlReq req);


    /**
     * 查询签署流程详情
     *
     * @param signFlowId 签署流程ID
     * @return
     */
    @GET("/v3/sign-flow/{signFlowId}/detail")
    Result<GetSignFlowDetailRes> detail(@Path("signFlowId") String signFlowId);


    /**
     * 撤销签署流程
     *
     * @return
     */
    @POST("/v3/sign-flow/{signFlowId}/revoke")
    Result revoke(@Path("signFlowId") String signFlowId, @Body SignFlowRevokeReq req);


    /**
     * 延长签署截止时间
     *
     * @param signFlowId 签署流程ID
     * @return
     */
    @POST("/v3/sign-flow/{signFlowId}/delay")
    Result delay(@Path("signFlowId") String signFlowId, @Body SignFlowDelayReq req);

    /**
     * 催签流程中签署人
     *
     * @param signFlowId 签署流程ID
     * @param req
     * @return
     */
    Result urge(@Path("signFlowId") String signFlowId, @Body SignFlowUrgeReq req);
}
