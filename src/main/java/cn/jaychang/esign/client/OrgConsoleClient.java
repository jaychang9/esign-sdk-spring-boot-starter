package cn.jaychang.esign.client;

import cn.jaychang.esign.client.interceptor.ESignRequestInterceptor;
import cn.jaychang.esign.dto.R;
import cn.jaychang.esign.dto.res.GetOrgConsoleUrlRes;
import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import cn.jaychang.esign.dto.req.GetOrgConsoleUrlReq;
import retrofit2.http.Body;
import retrofit2.http.POST;

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
    @POST("/v3/organizations/org-console-url")
    R<GetOrgConsoleUrlRes> getOrgConsoleUrl(@Body GetOrgConsoleUrlReq req);
}
