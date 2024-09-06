package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 个人实名认证配置项
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class PersonAuthConfig implements Serializable {
    private static final long serialVersionUID = -1161778302554190266L;

    /**
     * 个人用户账号标识（手机号或邮箱）
     * <p>
     * 【注】若未知用户的psnId/用户未实名，可以传此字段
     */
    private String psnAccount;

    /**
     * 个人账号ID
     * <p>
     * 【注】若已知用户的psnId/用户已实名，可以传此字段
     */
    private String psnId;

    /**
     * 个人身份附加信息
     */
    private PsnInfo psnInfo;


    private PsnAuthPageConfig psnAuthPageConfig;




    /**
     * 个人身份附加信息
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class PsnInfo implements Serializable {

        private static final long serialVersionUID = -4622895880862021984L;

        /**
         * 姓名
         */
        private String psnName;

        /**
         * 证件号码
         */
        private String psnIDCardNum;

        /**
         * 证件类型，可选值如下：
         * <p>
         * CRED_PSN_CH_IDCARD - 中国大陆居民身份证
         * <p>
         * CRED_PSN_CH_HONGKONG - 香港来往大陆通行证（回乡证）
         * <p>
         * CRED_PSN_CH_MACAO - 澳门来往大陆通行证（回乡证）
         * <p>
         * CRED_PSN_CH_TWCARD - 台湾来往大陆通行证（台胞证）
         * <p>
         * CRED_PSN_PASSPORT - 护照
         */
        private String psnIDCardType;

        /**
         * 人手机号（运营商实名登记手机号或银行卡预留手机号，仅用于认证）
         */
        private String psnMobile;

        /**
         * 个人银行卡号
         */
        private String bankCardNum;

        /**
         * 是否校验：psnAccount（个人用户账号标识）或 psnId（个人账号ID）绑定的e签宝个人信息与传入的psnInfo（个人身份信息）中的信息一致
         * <p>
         * true - 校验
         * <p>
         * false - 不校验（默认值）
         * <p>
         * 【注】若传true，则校验信息是否一致。若信息一致或用户未在e签宝注册认证过则正常发起，若信息不一致则报错：“传入的%s和该用户在e签宝的个人信息不一致” ，其中%s可能为多个字段，包含：姓名、证件号、实名手机号、银行卡号
         */
        private Boolean psnIdentityVerify;

    }

    /**
     * 个人实名认证页面配置项
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class PsnAuthPageConfig implements Serializable {

        private static final long serialVersionUID = -3478592175916121746L;

        /**
         * 设置页面中默认选择的实名认证方式，可选值如下：
         * <p>
         * PSN_FACE - 人脸识别认证（默认值）
         * <p>
         * PSN_MOBILE3 - 手机运营商三要素认证
         * <p>
         * PSN_BANKCARD4 - 银行卡四要素认证
         * <p>
         * 【注】使用iframe内嵌集成不支持对接刷脸方式
         */
        private String psnDefaultAuthMode;

        /**
         * 设置页面中可选择的个人认证方式范围，若不传此参数，则可选择全部认证方式。
         * <p>
         * PSN_FACE - 人脸识别认证
         * PSN_MOBILE3 - 手机运营商三要素认证
         * PSN_BANKCARD4 - 银行卡四要素认证
         * 【注】使用iframe内嵌集成不支持对接刷脸方式
         */
        private List<String> psnAvailableAuthModes;

        /**
         * 通过银行卡认证或运营商认证方式时，是否使用详情版（如指定则核验失败可返回具体不匹配信息），传空默认为普通版。
         * <p>
         * PSN_MOBILE3 - 手机运营商三要素认证
         * PSN_BANKCARD4 - 银行卡四要素认证
         * 【注】详情版：针对个人认证失败可以返回具体的不匹配信息，需要单独购买，具体购买方式请咨询e签宝商务人员；
         * <p>
         * 普通版：只返回信息比对核验失败，不会返回具体的不匹配信息。
         */
        private List<String> advancedVersion;


        /**
         * 设置页面中可编辑的个人信息字段，不传此参数，页面默认不允许编辑个人信息。
         * <p>
         * name - 姓名
         * IDCardNum - 证件号码（如果账号已实名，传了该字段，页面也是不可编辑更改的，因为证件号是唯一标识）
         * mobile - 个人手机号（仅针对实名认证手机号）
         * bankCardNum - 个人银行卡号
         */
        private List<String> psnEditableFields;
    }

}
