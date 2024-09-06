package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 控件位置信息
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class ComponentPosition implements Serializable {
    private static final long serialVersionUID = -5363729185852579103L;
    /**
     * 控件位置X横坐标
     */
    private Float componentPositionX;

    /**
     * 控件位置Y纵坐标
     */
    private Float componentPositionY;

    /**
     * 控件所在页码
     */
    private Integer componentPageNum;

}
