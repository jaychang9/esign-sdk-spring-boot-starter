package com.zcckj.esign.client;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import com.zcckj.esign.client.interceptor.ESignRequestInterceptor;
import com.zcckj.esign.dto.R;
import com.zcckj.esign.dto.req.Telecom3FactorsReq;
import com.zcckj.esign.dto.res.Telecom3FactorsRes;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 运营商三要素验证
 *
 * @author zhangjie
 */
@RetrofitClient(baseUrl = "${esign.base-url}")
@Intercept(handler = ESignRequestInterceptor.class)
public interface IdentityVerifyClient {
    /**
     * 个人运营商3要素信息比对
     * @return
     */
    @POST("/v2/identity/verify/individual/telecom3Factors")
    R<Telecom3FactorsRes> telecom3Factors(@Body Telecom3FactorsReq req);
}
