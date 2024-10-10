package cn.jaychang.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 签章区属性
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class ComponentNormalSignField {
    private static final long serialVersionUID = 8661962459978663770L;

    /**
     * 是否显示签署日期
     *
     * 0 - 不显示，1 - 显示
     */
    private Integer showSignDate;

    /**
     * 日期格式，支持以下日期格式：
     *
     * yyyy年MM月dd日
     *
     * yyyy-MM-dd
     *
     * yyyy/MM/dd
     *
     * yyyy-MM-dd HH:mm:ss
     */
    private String dateFormat;

    /**
     * 签章样式
     *
     * 1 - 单页签章，2 - 骑缝签章
     */
    private Integer signFieldStyle;

    /**
     * 落章规则
     *
     * 1 - 以实际印章规格加盖
     *
     * 2 - 自定义印章规格加盖（根据指定的签署区宽高适配
     */
    private Integer sealSpecs;

}
