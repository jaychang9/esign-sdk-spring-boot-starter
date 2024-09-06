package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 控件尺寸
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class ComponentSize implements Serializable {
    private static final long serialVersionUID = 5155117200166337288L;
    /**
     * 控件宽度（矩形的左右距离，单位为px）
     */
    private Float componentWidth;

    /**
     * 控件高度（矩形的上下距离，单位为px）
     */
    private Float componentHeight;


}
