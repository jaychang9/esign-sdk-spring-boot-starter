package com.zcckj.esign.client;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import com.zcckj.esign.client.interceptor.ESignRequestInterceptor;
import com.zcckj.esign.dto.R;
import com.zcckj.esign.dto.req.*;
import com.zcckj.esign.dto.res.*;
import retrofit2.http.*;

/**
 * 合同模板
 *
 * @author zhangjie
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
    R<GetDocTemplateCreateUrlRes> getDocTemplateCreateUrl(@Body GetDocTemplateCreateUrlReq req);


    /**
     * 获取编辑合同模板页面
     *
     * @return
     */
    @POST("/v3/doc-templates/{docTemplateId}/doc-template-edit-url")
    R<GetDocTemplateEditUrlRes> getDocTemplateEditUrl(@Path("docTemplateId") String docTemplateId, @Body GetDocTemplateEditUrlReq req);

    /**
     * 获取预览合同模板页面
     *
     * @return
     */
    @POST("/v3/doc-templates/doc-template-preview-url")
    R<GetDocTemplatePreviewUrlRes> getDocTemplatePreviewUrl(@Body GetDocTemplatePreviewUrlReq req);


    /**
     * 查询合同模板中控件详情
     *
     * @return
     */
    @GET("/v3/doc-templates/{docTemplateId}")
    R<GetDocTemplateComponentsRes> getDocTemplateComponents(@Path("docTemplateId") String docTemplateId);

    /**
     * 填写模板生成文件
     *
     * @return
     */
    @POST("/v3/files/create-by-doc-template")
    R<CreateByDocTemplateRes> createByDocTemplate(@Body CreateByDocTemplateReq req);

    /**
     * 复制合同模板
     *
     * @return
     */
    @POST("/v3/doc-templates/{docTemplateId}/copy")
    R<CopyDocTemplateRes> copyDocTemplate(@Path("docTemplateId") String docTemplateId, @Body CopyDocTemplateReq req);

    /**
     * 删除合同模板
     *
     * @param docTemplateId 合同模板ID
     * @return
     */
    @DELETE("/v3/doc-templates/{docTemplateId}")
    R deleteDocTemplate(@Path("docTemplateId") String docTemplateId);


    /**
     * 查询PDF模板填写后文件
     */
    @GET("/v3/files/{fileId}")
    R<GetFileDownloadUrlRes> getFileDownloadUrl(@Path("fileId") String fileId, @Query("pageSize") Boolean pageSize);

    /**
     * 导出合同模板(仅支持沙箱模拟环境)
     *
     * @param req
     * @return
     */
    @POST("/v3/doc-templates/export")
    R<DocTemplateExportRes> docTemplatesExport(@Body DocTemplateExportReq req);


    /**
     * 导出合同模板(仅支持沙箱模拟环境)
     *
     * @param req
     * @return
     */
    @POST("/v3/doc-templates/import")
    R<DocTemplateImportRes> docTemplatesImport(@Body DocTemplateImportReq req);

}
