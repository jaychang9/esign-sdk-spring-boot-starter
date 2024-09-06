package com.zcckj.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取编辑合同模板页面请求体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetDocTemplateCreateUrlReq implements Serializable {
    private static final long serialVersionUID = -1264405297162091629L;
    /**
     * 模板名称（可自定义模板名称）
     */
    private String docTemplateName;
    /**
     * 模板类型，默认值为 0
     * 0 - PDF模板
     * 1 - HTML模板（适用动态增加表格行并填充内容场景）
     */
    private Integer docTemplateType;
    /**
     * 底稿文件ID（原始文件的编号）
     *
     * 在此底稿文件ID的基础上，添加各类控件来创建合同模板；
     * 文件ID通过【上传本地文件】接口获取。
     */
    private String fileId;
    /**
     * 制作模板完成后页面重定向跳转地址（需符合 https /http 协议地址）
     */
    private String redirectUrl;

}
