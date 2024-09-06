package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 签署流程配置项-签署配置
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignFlowSignConfig implements Serializable {
    private static final long serialVersionUID = 413854834678624879L;

    /**
     * 签署终端类型，默认值：1,2（英文逗号分隔）
     *
     * （点击了解 网页端OR支付宝端签署）
     *  https://open.esign.cn/doc/opendoc/case3/km9lo5php780z8dk
     * 1 - 网页（自适配H5/PC样式），2 - 支付宝
     *
     * 【注】如果是开发者自己的app或者支付宝小程序等端内嵌e签宝H5/PC，需要传：1（网页端）
     */
    private String availableSignClientTypes;

    /**
     * 签署页面是否显示“同时盖在所有签署区”按钮，默认值 true
     *
     * true - 显示（显示按钮并默认开启）
     *
     * false - 不显示（不显示按钮，即：不能同时盖在所有签署区）
     */
    private Boolean showBatchDropSealButton;

    /**
     * 签署模式，默认：NORMAL
     *
     * NORMAL - 中国大陆签
     *
     * GLOBAL - 海外签
     *
     * 【注】海外签需要购买对应套餐才可以使用
     */
    private String signMode;

    /**
     * 专属云项目ID
     *
     * 补充说明：
     *
     * 专属云：文件需要存储在开发者本地系统，购买了专属云服务时使用；
     * 专属云项目ID需要先在【获取文件上传地址】接口传入，这里传同一个项目ID才可用。
     */
    private String dedicatedCloudId;
}
