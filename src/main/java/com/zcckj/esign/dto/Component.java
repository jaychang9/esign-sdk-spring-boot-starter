package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 模板中的控件信息
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class Component {
    private static final long serialVersionUID = 8661962459978663770L;

    /**
     * 控件ID（设置合同文件模板时由e签宝系统生成）
     */
    private String componentId;
    /**
     * 控件Key（设置合同文件模板时由用户自定义）
     */
    private String componentKey;
    /**
     * 控件名称
     */
    private String componentName;
    /**
     * 控件是否必填
     *
     * true - 必填，false - 非必填
     */
    private Boolean required;
    /**
     * 控件类型
     *
     * 1 - 单行文本，2 - 数字，3 - 日期，6 - 签章区域，8 - 多行文本，9 - 复选，10 - 单选，11 - 图片，14 -下拉框，15 - 勾选框，16 - 身份证，17 - 备注区域，18 - 动态表格，19 - 手机号
     */
    private Integer componentType;

    /**
     * 控件位置信息
     */
    private ComponentPosition componentPosition;

    /**
     * 控件特有属性
     */
    private ComponentSpecialAttribute componentSpecialAttribute;
    /**
     * 控件尺寸
     */
    private ComponentSize componentSize;

    /**
     * 签章区属性
     */
    private ComponentNormalSignField normalSignField;

    /**
     * 备注区属性
     */
    private ComponentRemarkSignField remarkSignField;

    /**
     * 自定义控件ID
     */
    private String originCustomComponentId;
}
