package cn.jaychang.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 签署文件信息
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class FileInfo implements Serializable {

    private static final long serialVersionUID = 2535016227472987024L;

    /**
     * 签署文件ID
     */
    private String fileId;

    /**
     * 签署文件名称
     */
    private String fileName;

    /**
     * 已签署文件下载链接（有效期为60分钟，过期后可以重新调用接口获取新的下载地址）
     */
    private String downloadUrl;
}