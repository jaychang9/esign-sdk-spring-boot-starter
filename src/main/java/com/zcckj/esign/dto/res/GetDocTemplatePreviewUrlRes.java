package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取预览合同模板页面响应体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetDocTemplatePreviewUrlRes implements Serializable {
    private static final long serialVersionUID = -221580072034462022L;
    /**
     * 合同模板ID
     */
    private String docTemplateId;
    /**
     * 预览文件模板页面链接，有效期30分钟，过期可以重新获取
     */
    private String docTemplatePreviewUrl;
}
