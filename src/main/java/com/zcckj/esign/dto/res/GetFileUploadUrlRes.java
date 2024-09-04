package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 获取文件上传地址响应结果
 */
@Data
@Accessors(chain = true)
public class GetFileUploadUrlRes {
    /** 文件上传地址，链接有效期60分钟*/
    private String fileUploadUrl;
    /** 文件ID*/
    private String fileId;
}
