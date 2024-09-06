package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 独立签署日期配置项
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class DateSignFieldConfig implements Serializable {
    private static final long serialVersionUID = 1527654505601077508L;

    /**
     * 是否是后台自动落章关联的独立签署日期，默认值 false
     *
     * true - 后台自动落章关联的独立签署日期（平台静默签署）
     *
     * false - 签署页手动签章关联的独立签署日期
     *
     * 【注】当关联的普通签署区包含自动签，即签署区数组中存在normalSignFieldConfig中的autoSign=true时，该字段才允许传true
     */
    private Boolean autoSign;

    /**
     * 日期格式
     *
     * yyyy年MM月dd日（默认值）
     *
     * yyyy-MM-dd
     *
     * yyyy/MM/dd
     *
     * yyyy.MM.dd
     *
     * yyyy年M月d日
     *
     * yyyy年M月
     *
     * yyyy/M/d
     *
     * yy-MM-dd
     */
    private String dateFormat;

    /**
     * 日期字体大小，默认值12px（可传入5-42）
     */
    private Integer fontSize;

    /**
     * 指定签署日期位置页码
     *
     * 【注】允许与签署区位置positionPage的值不一样，即允许跨页添加签署日期
     */
    private Integer signDatePositionPage;

    /**
     * 签署日期所在位置X坐标
     */
    private Float signDatePositionX;

    /**
     * 签署日期所在位置Y坐标
     */
    private Float signDatePositionY;
}
