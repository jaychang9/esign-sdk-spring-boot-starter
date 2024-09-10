package com.zcckj.esign.client;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import com.zcckj.esign.client.interceptor.ESignRequestInterceptor;
import com.zcckj.esign.dto.R;
import com.zcckj.esign.dto.req.GetOrgConsoleUrlReq;
import com.zcckj.esign.dto.res.GetOrgConsoleUrlRes;
import retrofit2.http.Body;

/**
 * 企业控制台
 *
 * @author zhangjie
 */
@RetrofitClient(baseUrl = "${esign.base-url}")
@Intercept(handler = ESignRequestInterceptor.class)
public interface OrgConsoleClient {

    /**
     * 获取免登录企业控制台页面
     *
     * @return
     */
    R<GetOrgConsoleUrlRes> getOrgConsoleUrl(@Body GetOrgConsoleUrlReq req);
}
