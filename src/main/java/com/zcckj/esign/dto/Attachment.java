package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 附属材料信息
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class Attachment implements Serializable {

    /**
     * 附属材料文件ID
     */
    private String fileId;

    /**
     * 附属材料名称（需要添加文件真实后缀名，例如：“xxx.pdf”）
     *
     * 【注】名称不可含有以下9个特殊字符：/ \ : * " < > | ？以及所有emoji表情
     */
    private String fileName;
}
