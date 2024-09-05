package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取制作合同模板页面响应体
 */
@Data
@Accessors(chain = true)
public class GetDocTemplateCreateUrlRes implements Serializable {
    private static final long serialVersionUID = 6081149879271814277L;
    /**
     * 合同模板ID（建议开发者保管，当制作合同模板的链接过期失效后，可用于再次获取该模板的编辑链接，以及之后填充控件内容）
     */
    private String docTemplateId;
    /**
     * 制作合同模板的页面短链接（有效期24小时）
     */
    private String docTemplateCreateUrl;
    /**
     * 制作合同模板的页面长链接（有效期24小时）
     */
    private String docTemplateCreateLongUrl;

}
