package cn.jaychang.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 备注区配置项
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class RemarkSignFieldConfig implements Serializable {
    private static final long serialVersionUID = -1435150876138077365L;

    /**
     * 自由备注模式，默认值 false
     *
     * true - 是，false - 否。
     *
     * 补充说明：
     *
     * 自由备注 指由用户选择是否备注，且不限备注位置和备注区个数。
     */
    private Boolean freeMode;

    /**
     * 文字输入方式，默认值：1
     *
     * 1 - 手写抄录方式，2 - 键盘输入方式
     *
     * 【注】inputType=2（键盘输入方式）时，aiCheck和remarkContent参数值不生效
     */
    private Integer inputType;

    /**
     * 是否开启手写抄录AI校验，默认值：0
     *
     * 0 - 不开启 ，1 - 开启 AI 校验 ，2 - 强制 AI 校验
     */
    private Integer aiCheck;

    /**
     * 预设待抄录信息（最多支持100个汉字，含标点符号，内容中输入\n可以换行）
     *
     * 【注】inputType=1时手写抄录方式此参数必须传值
     */
    private String remarkContent;

    /**
     * 备注区是否可以移动，默认值 false
     *
     * true - 可移动，false - 位置固定
     */
    private Boolean movableSignField;

    /**
     * 备注文字字号，默认值14px
     */
    private Integer remarkFontSize;

    /**
     * 备注区高度（矩形的上下距离，单位为px）
     */
    private Float signFieldHeight;

    /**
     * 备注区宽度（矩形的左右距离，单位为px）
     */
    private Float signFieldWidth;

    /**
     * 备注区位置
     */
    private SignFieldPosition signFieldPosition;
}
