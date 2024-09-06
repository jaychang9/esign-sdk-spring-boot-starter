package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 签章区配置项
 */
@Data
@Accessors(chain = true)
public class NormalSignFieldConfig implements Serializable {

    private static final long serialVersionUID = -5791358537166021563L;

    /**
     * 是否自由签章，默认值 false
     * <p>
     * （点击了解 指定位置签章与自由签章）
     * https://open.esign.cn/doc/opendoc/case3/tgvrtoz21b06dqgc
     * true - 是，false - 否
     * <p>
     * 补充说明：
     * <p>
     * 自由签章 指不限制印章、签署位置、签章样式（单页、骑缝）、和签章个数。
     * 自由签章模式下，无需传normalSignFieldConfig对象下的其他参数。
     */
    private Boolean freeMode;

    /**
     * 是否后台自动落章，默认值 false
     * <p>
     * true - 后台自动落章（无感知），false - 签署页手动签章
     * <p>
     * 补充说明：
     * <p>
     * 当签署方为个人时，不支持自动签章。
     * 当签署方为机构（且非应用Id所属企业），静默签署自动落章需先经过印章授权，点击查看印章授权规则。
     * https://open.esign.cn/doc/opendoc/seal3/vk863c
     * 当签署方为应用Id所属主体企业自身静默签署时，支持后台自动落章。
     */
    private Boolean autoSign;

    /**
     * 指定印章ID（印章ID是e签宝SaaS官网的印章编号，点击查看 获取方式）
     * https://open.esign.cn/doc/opendoc/helper/xvglqhiq48prkf4m
     * 【注】平台方企业自动落章场景，如不指定印章ID，则取平台默认印章
     */
    private String assignedSealId;

    /**
     * 签章区尺寸（正方形的边长，单位为px）
     * <p>
     * 【注】不指定默认以印章原始大小展示
     */
    private Float signFieldSize;

    /**
     * 签章区样式
     * <p>
     * 1 - 单页签章，2 - 骑缝签章（点击了解 骑缝盖章）
     */
    private Integer signFieldStyle;

    /**
     * 签章区位置信息
     * <p>
     * （点击了解 指定位置签章与自由签章）
     * https://open.esign.cn/doc/opendoc/case3/tgvrtoz21b06dqgc
     */
    private SignFieldPosition signFieldPosition;


}
