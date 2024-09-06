package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 控件特有属性
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class ComponentSpecialAttribute implements Serializable {
    private static final long serialVersionUID = 495467345633522614L;

    /**
     * 日期格式（日期控件特有）
     */
    private String dateFormat;

    /**
     * 图片类型（图片控件特有）
     * <p>
     * IDCard_widthwise（身份证横向，等比缩放大小）
     * <p>
     * IDCard_longitudinal（身份证纵向，等比缩放大小）
     * <p>
     * other （其他，自由缩放大小）
     */
    private String imageType;

    /**
     * 选项（下拉框控件、单选控件、多选控件特有）
     */
    private List<ComponentSpecialAttributeOption> options;

    /**
     * 表格行列内容（动态表格控件特有），格式：
     *
     * [row{"column1":"value1","column2":"value2"}]
     *
     * 补充说明：
     *
     * row 表示动态表格对应的行，row的个数依据模板动态表格控件中所添加的所添加的行数。
     * column1 表示当前行中单元格的Key值
     * value1 表示当前行中单元格的Value值，单元格未设置固定值时为""空字符串，否则为所设置的固定值。
     * 详见 tableContent 解释说明。
     * https://open.esign.cn/doc/opendoc/case3/ubfvvk?#KqzSo
     */
    private String tableContent;

    /**
     * 数字格式（数字控件特有），格式如下：
     *
     * 0 - 整数，0.0 - 保留一位小数，0.00 - 保留两位小数
     */
    private String numberFormat;


    /**
     * 可填充的长度上限，单位：中文字符
     *
     * 【注】1个中文字符=2个英文字符；
     *
     * 仅适用于制作PDF模板时，返回此参数；
     */
    private String componentMaxLength;

    /**
     * 签署方角色标识（签署区控件）
     */
    private String signerRole;




}
