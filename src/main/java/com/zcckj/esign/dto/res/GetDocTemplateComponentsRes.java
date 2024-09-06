package com.zcckj.esign.dto.res;

import com.zcckj.esign.dto.Component;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 查询合同模板中控件详情响应体
 */
@Data
@Accessors(chain = true)
public class GetDocTemplateComponentsRes implements Serializable {

    private static final long serialVersionUID = -2633360583915911159L;
    /**
     * 合同模板ID
     */
    private String docTemplateId;
    /**
     * 合同模板名称
     */
    private String docTemplateName;
    /**
     * 合同模板创建时间（Unix时间戳格式，单位：毫秒）
     */
    private Long createTime;
    /**
     * 合同模板更新时间（Unix时间戳格式，单位：毫秒）
     */
    private Long updateTime;
    /**
     * 合同模板的底稿PDF文件下载链接
     *
     * 链接有效期为60分钟
     * 当模板类型为html模板时，默认会返回 null
     */
    private String fileDownloadUrl;

    /**
     * 模板中的控件列表信息
     */
    private List<Component> components;
}
