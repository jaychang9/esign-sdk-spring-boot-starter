package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取下载签署中文件地址响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetPreviewFileDownloadUrlRes implements Serializable {
    private static final long serialVersionUID = 5272640697892793069L;

    /**
     * 文件ID
     */
    private String fileId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 签署中文件下载链接（有效期为60分钟，过期后可以重新调用接口获取新的下载地址）
     */
    private String fileDownloadUrl;

}
