package cn.jaychang.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取编辑合同模板页面响应体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetDocTemplateEditUrlRes implements Serializable {

    private static final long serialVersionUID = 2584042878456006936L;
    /**
     * 制作合同模板的页面短链接（有效期24小时）
     */
    private String docTemplateEditUrl;
    /**
     * 制作合同模板的页面长链接（有效期24小时）
     */
    private String docTemplateEditLongUrl;

}
