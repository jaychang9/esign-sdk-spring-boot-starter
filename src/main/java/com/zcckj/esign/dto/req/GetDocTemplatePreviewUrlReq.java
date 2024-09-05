package com.zcckj.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取预览合同模板页面请求体
 */
@Data
@Accessors(chain = true)
public class GetDocTemplatePreviewUrlReq implements Serializable {
    private static final long serialVersionUID = -6040902450619448480L;

    /**
     * 合同模板ID
     */
    private String docTemplateId;
}
