package com.zcckj.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 文件模板创建或编辑完成通知
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class EditDocTemplateCb implements Serializable {
    private static final long serialVersionUID = -6088318359952808351L;
    /**
     * 标记该通知的业务类型，该通知固定为：EDIT_DOCTEMPLATE
     */
    private String action;
    /**
     * 文件模板ID
     */
    private String docTemplateId;
    /**
     * 文件模板名称
     */
    private String docTemplateName;
    /**
     * 回调通知发送时间（如重试多次均返回第一次时间，毫秒级时间戳格式）
     */
    private Long timestamp;
}
