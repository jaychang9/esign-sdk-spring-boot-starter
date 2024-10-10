package cn.jaychang.esign.client;

import cn.jaychang.esign.client.interceptor.ESignRequestInterceptor;
import cn.jaychang.esign.dto.R;
import cn.jaychang.esign.dto.req.Telecom3FactorsReq;
import cn.jaychang.esign.dto.res.Telecom3FactorsRes;
import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
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
