package com.zcckj.esign.client;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import com.zcckj.common.mvc.result.Result;
import com.zcckj.esign.client.interceptor.ESignRequestInterceptor;
import com.zcckj.esign.dto.req.CreateByDocTemplateReq;
import com.zcckj.esign.dto.req.GetDocTemplateCreateUrlReq;
import com.zcckj.esign.dto.req.GetDocTemplateEditUrlReq;
import com.zcckj.esign.dto.req.GetDocTemplatePreviewUrlReq;
import com.zcckj.esign.dto.res.*;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 合同模板类
 */
@RetrofitClient(baseUrl = "${esign.base-url}")
@Intercept(handler = ESignRequestInterceptor.class)
public interface DocTemplateClient {
    /**
     * 获取制作合同模板页面
     *
     * @return
     */
    @POST("/v3/doc-templates/doc-template-create-url")
    Result<GetDocTemplateCreateUrlRes> getDocTemplateCreateUrl(@Body GetDocTemplateCreateUrlReq req);


    /**
     * 获取编辑合同模板页面
     *
     * @return
     */
    @POST("/v3/doc-templates/{docTemplateId}/doc-template-edit-url")
    Result<GetDocTemplateEditUrlRes> getDocTemplateEditUrl(@Path("docTemplateId") String docTemplateId, @Body GetDocTemplateEditUrlReq req);

    /**
     * 获取预览合同模板页面
     *
     * @return
     */
    @POST("/v3/doc-templates/doc-template-preview-url")
    Result<GetDocTemplatePreviewUrlRes> getDocTemplatePreviewUrl(@Body GetDocTemplatePreviewUrlReq req);


    /**
     * 查询合同模板中控件详情
     *
     * @return
     */
    @GET("/v3/doc-templates/{docTemplateId}")
    Result<GetDocTemplateComponentsRes> getDocTemplateComponents(@Path("docTemplateId") String docTemplateId);

    /**
     * 填写模板生成文件
     * @return
     */
    @POST("/v3/files/create-by-doc-template")
    Result<CreateByDocTemplateRes> createByDocTemplate(@Body CreateByDocTemplateReq req);
}
