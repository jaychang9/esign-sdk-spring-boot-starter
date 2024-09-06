package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Doc implements Serializable {
    /**
     * 待签署文件ID
     */
    private String fileId;
    /**
     * 文件名称（需要添加PDF文件后缀名，“xxx.pdf”）
     * <p>
     * 【注】文件名称不可含有以下9个特殊字符：/ \ : * " < > | ？以及所有emoji表情
     */
    private String fileName;
}
