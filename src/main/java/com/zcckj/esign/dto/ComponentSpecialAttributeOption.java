package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 控件特有属性
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class ComponentSpecialAttributeOption implements Serializable {
    private static final long serialVersionUID = 495467345633522614L;

    /**
     * 选项内容
     */
    private String optionContent;

    /**
     * 选项顺序
     */
    private Integer optionOrder;

    /**
     * 选项是否默认选中
     */
    private Boolean selected;



}
