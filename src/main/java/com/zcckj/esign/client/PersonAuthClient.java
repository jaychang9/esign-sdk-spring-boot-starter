package com.zcckj.esign.client;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import com.zcckj.esign.client.interceptor.ESignRequestInterceptor;
import com.zcckj.esign.dto.R;
import com.zcckj.esign.dto.req.GetPersonAuthReq;
import com.zcckj.esign.dto.req.GetPersonIdentityInfoReq;
import com.zcckj.esign.dto.res.GetPersonAuthRes;
import com.zcckj.esign.dto.res.GetPersonAuthorizedInfoRes;
import com.zcckj.esign.dto.res.GetPersonIdentityInfoRes;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 个人实名认证和授权
 *
 * @author zhangjie
 */
@RetrofitClient(baseUrl = "${esign.base-url}")
@Intercept(handler = ESignRequestInterceptor.class)
public interface PersonAuthClient {
    /**
     * 获取个人认证&授权页面链接
     *
     * @return
     */
    @POST("/v3/psn-auth-url")
    R<GetPersonAuthRes> getPsnAuthUrl(@Body GetPersonAuthReq req);

    /**
     * 查询个人认证信息
     *
     * @param req
     * @return
     */
    @GET("/v3/persons/identity-info")
    R<GetPersonIdentityInfoRes> getPersonIdentityInfo(@Body GetPersonIdentityInfoReq req);


    /**
     * 查询个人认证信息
     *
     * @param psnId 个人账号ID（或企业经办人账号ID）
     * @return
     */
    @GET("/v3/persons/{psnId}/authorized-info")
    R<GetPersonAuthorizedInfoRes> getPersonIdentityInfo(@Path("psnId") String psnId);
}
