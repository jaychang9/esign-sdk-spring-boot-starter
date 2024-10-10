package cn.jaychang.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取文件上传地址响应体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetFileUploadUrlRes implements Serializable {
    private static final long serialVersionUID = 353724373445927741L;
    /** 文件上传地址，链接有效期60分钟*/
    private String fileUploadUrl;
    /** 文件ID*/
    private String fileId;
}
