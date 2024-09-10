package com.zcckj.esign.dto.res;

import com.zcckj.esign.dto.FileInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 下载已签署文件及附属材料响应体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetSignedFileDownloadUrlRes implements Serializable {
    private static final long serialVersionUID = 3879701620250764953L;


    /**
     * 海外签证书报告下载地址（有效期为60分钟，过期后可以重新调用接口获取新的下载地址）
     *
     * 【注】默认中国大陆签署不返回值
     */
    private String certificateDownloadUrl;

    /**
     * 签署文件信息
     */
    private List<FileInfo> files;

    /**
     * 附属材料信息
     */
    private List<FileInfo> attachments;

}
