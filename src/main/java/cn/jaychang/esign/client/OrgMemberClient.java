package cn.jaychang.esign.client;

import cn.jaychang.esign.client.interceptor.ESignRequestInterceptor;
import cn.jaychang.esign.dto.R;
import cn.jaychang.esign.dto.res.GetAdministratorsRes;
import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 企业成员管理
 *
 * @author zhangjie
 */
@RetrofitClient(baseUrl = "${esign.base-url}")
@Intercept(handler = ESignRequestInterceptor.class)
public interface OrgMemberClient {

    /**
     * 查询企业管理员
     *
     * @return
     */
    @POST("/v3/organizations/{orgId}/administrators")
    R<GetAdministratorsRes> getAdministrators(@Path("orgId") String orgId);
}
