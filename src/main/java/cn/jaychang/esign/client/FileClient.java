package cn.jaychang.esign.client;

import cn.jaychang.esign.client.interceptor.ESignRequestInterceptor;
import cn.jaychang.esign.dto.R;
import cn.jaychang.esign.dto.res.GetFileUploadStatusRes;
import cn.jaychang.esign.dto.res.GetFileUploadUrlRes;
import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import cn.jaychang.esign.dto.req.GetFileUploadUrlReq;
import retrofit2.http.*;

/**
 * 文件
 * @author zhangjie
 */
@RetrofitClient(baseUrl = "${esign.base-url}")
@Intercept(handler = ESignRequestInterceptor.class)
public interface FileClient {
    /**
     * 获取文件上传地址
     *
     * @param req 请求体
     * @return
     */
    @POST("/v3/files/file-upload-url")
    R<GetFileUploadUrlRes> getFileUploadUrl(@Body GetFileUploadUrlReq req);

    /**
     * 查询文件上传状态
     *
     * @param req 请求体
     * @return
     */
    @GET("/v3/files/{fileId}")
    R<GetFileUploadStatusRes> getFileUploadStatus(@Path("fileId") String fileId, @Query("pageSize") Boolean pageSize);

}
