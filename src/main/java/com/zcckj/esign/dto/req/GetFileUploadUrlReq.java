package com.zcckj.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取文件上传地址请求
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetFileUploadUrlReq implements Serializable {
    private static final long serialVersionUID = -6216305946100581155L;
    /**
     * 文件的Content-MD5值
     */
    private String contentMd5;
    /**
     * 目标文件的MIME类型
     */
    private String contentType;
    /**
     * 是否需要转换成PDF文档，默认值 false
     */
    private Boolean convertToPDF;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件大小，单位: byte字节
     */
    private Long fileSize;
}
