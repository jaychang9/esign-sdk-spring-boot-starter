package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 签署人签署配置项
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignConfig implements Serializable {
    private static final long serialVersionUID = -3092883406164758291L;
    /**
     * 设置页面强制阅读倒计时时间，默认值为 0（单位：秒，最大值999）
     */
    private Integer forcedReadingTime;
    /**
     * 设置签署方的签署顺序
     *
     * 按序签时支持传入顺序值 1 - 255（值小的先签署）
     * 同时签时，允许值重复
     */
    private Integer signOrder;
}