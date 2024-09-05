package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 填写模板生成文件响应体
 */
@Data
@Accessors(chain = true)
public class CreateByDocTemplateRes implements Serializable {

    private static final long serialVersionUID = -7939808983122596600L;

    /**
     * 填充后生成的文件ID
     */
    private String fileId;

    /**
     * 文件下载地址（有效期为60分钟，过期后可以重新调用接口获取新的下载地址）
     * <p>
     * 填充PDF模板时，返回填充后的文件下载地址。
     * 填充HTML模板时，默认返回null，如需获取文件下载地址，建议调用【查询文件上传状态】接口，传入上方参数“填充后生成的文件ID”的返回值来获取。
     */
    private String fileDownloadUrl;

}
