package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 签章区属性
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class ComponentRemarkSignField {
    private static final long serialVersionUID = 8661962459978663770L;

    /**
     * 是否开启手写抄录AI校验
     * <p>
     * 0 - 不开启，1 - 开启 AI 校验，2 - 强制 AI 校验
     */
    private Integer aiCheck;

    /**
     * 备注文字输入方式
     * <p>
     * 1 - 手写抄录方式，2 - 自由输入方式
     */
    private Integer inputType;

    /**
     * 预设手写抄录信息
     */
    private String remarkContent;

    /**
     * 备注文字的字号，单位pt，默认值12pt
     * <p>
     * 注：签署侧需要的字号单位是px，模板侧通用的都是pt，因此要做一次转换；pt与px间的换算关系是：0.75px=1pt
     */
    private String remarkFontSize;

}
