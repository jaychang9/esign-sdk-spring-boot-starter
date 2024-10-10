package cn.jaychang.esign.client;

import cn.jaychang.esign.client.interceptor.ESignRequestInterceptor;
import cn.jaychang.esign.dto.R;
import cn.jaychang.esign.dto.res.*;
import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import cn.jaychang.esign.dto.req.GetOrgAuthReq;
import cn.jaychang.esign.dto.req.GetPersonAuthReq;
import retrofit2.http.*;

/**
 * 实名认证和授权
 *
 * @author zhangjie
 */
@RetrofitClient(baseUrl = "${esign.base-url}")
@Intercept(handler = ESignRequestInterceptor.class)
public interface AuthClient {
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
     * @param psnId         个人账号ID
     * @param psnAccount    个人账号标识（手机号或邮箱）
     * @param psnIDCardNum  个人用户的证件号
     * @param psnIDCardType 个人证件号类型 （传psnIDCardNum时，证件类型为必传项）
     *                      <p>
     *                      CRED_PSN_CH_IDCARD - 中国大陆居民身份证
     *                      <p>
     *                      CRED_PSN_CH_HONGKONG - 香港来往大陆通行证
     *                      <p>
     *                      CRED_PSN_CH_MACAO - 澳门来往大陆通行证
     *                      <p>
     *                      CRED_PSN_CH_TWCARD - 台湾来往大陆通行证
     *                      <p>
     *                      CRED_PSN_PASSPORT - 护照
     * @return
     */
    @GET("/v3/persons/identity-info")
    R<GetPersonIdentityInfoRes> getPersonIdentityInfo(@Query("psnId") String psnId, @Query("psnAccount") String psnAccount, @Query("psnIDCardNum") String psnIDCardNum, @Query("psnIDCardType") String psnIDCardType);


    /**
     * 查询个人授权信息
     *
     * @param psnId 个人账号ID（或企业经办人账号ID）
     * @return
     */
    @GET("/v3/persons/{psnId}/authorized-info")
    R<GetPersonAuthorizedInfoRes> getPersonAuthorizedInfo(@Path("psnId") String psnId);


    /**
     * 获取机构认证&授权页面链接
     *
     * @return
     */
    @POST("/v3/org-auth-url")
    R<GetOrgAuthRes> getOrgAuthUrl(@Body GetOrgAuthReq req);

    /**
     * 查询机构认证信息
     *
     * @param orgId         机构账号ID
     * @param orgName       组织机构名称
     * @param orgIDCardNum  组织机构证件号
     * @param orgIDCardType 组织机构证件类型（传orgIDCardNum时，该参数为必传）
     *                      <p>
     *                      CRED_ORG_USCC - 统一社会信用代码
     *                      <p>
     *                      CRED_ORG_REGCODE - 工商注册号
     * @return
     */
    @GET("/v3/organizations/identity-info")
    R<GetOrgIdentityInfoRes> getOrgIdentityInfo(@Query("orgId") String orgId, @Query("orgName") String orgName, @Query("orgIDCardNum") String orgIDCardNum, @Query("orgIDCardType") String orgIDCardType);


    /**
     * 查询机构授权信息
     *
     * @param orgId 机构账号ID
     * @return
     */
    @GET("/v3/organizations/{orgId}/authorized-info")
    R<GetOrgAuthorizedInfoRes> getOrgAuthorizedInfo(@Path("orgId") String orgId);


    /**
     * 查询认证授权流程详情
     *
     * @param authFlowId 认证授权流程ID 通过【获取个人认证&授权页面链接】或【获取机构认证&授权页面链接】接口获取。
     * @return
     */
    @GET("/v3/auth-flow/{authFlowId}")
    R<GetAuthFlowDetailRes> getAuthFlowDetail(@Path("authFlowId") String authFlowId);


}
