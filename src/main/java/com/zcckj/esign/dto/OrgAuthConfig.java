package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 组织机构认证配置项
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class OrgAuthConfig implements Serializable {

    private static final long serialVersionUID = 7955667307949230074L;


    /**
     * 组织机构名称（机构账号标识）
     * <p>
     * （若未知机构的orgId/机构未实名，请传此字段）
     */
    private String orgName;

    /**
     * 机构账号ID
     * <p>
     * （若已知机构的orgId/机构已实名，请传此字段）
     */
    private String orgId;

    /**
     * 组织机构身份附加信息
     */
    private OrgInfo orgInfo;

    /**
     * 机构实名认证页面配置项
     */
    private OrgAuthPageConfig orgAuthPageConfig;

    /**
     * 经办人身份信息
     * <p>
     * （如果不传经办人个人的账号信息，则需要经办人自主在页面填写手机号/邮箱进行验证码回填注册）
     */
    private TransactorInfo transactorInfo;

    /**
     * 经办人认证页面设置
     */
    private TransactorAuthPageConfig transactorAuthPageConfig;

    /**
     * 组织机构身份附加信息
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class OrgInfo implements Serializable {

        private static final long serialVersionUID = -7168802297819360400L;

        /**
         * 组织机构证件号
         */
        private String orgIDCardNum;
        /**
         * 组织机构证件类型，可选值如下：
         * <p>
         * CRED_ORG_USCC - 统一社会信用代码
         * CRED_ORG_REGCODE - 工商注册号
         */
        private String orgIDCardType;
        /**
         * 法定代表人姓名
         */
        private String legalRepName;
        /**
         * 法定代表人证件号
         */
        private String legalRepIDCardNum;
        /**
         * 法定代表人证件类型，可选值如下：
         * <p>
         * CRED_PSN_CH_IDCARD - 中国大陆居民身份证
         * CRED_PSN_CH_HONGKONG - 香港来往大陆通行证（回乡证）
         * CRED_PSN_CH_MACAO - 澳门来往大陆通行证（回乡证）
         * CRED_PSN_CH_TWCARD - 台湾来往大陆通行证（台胞证）
         * CRED_PSN_PASSPORT - 护照
         */
        private String legalRepIDCardType;
        /**
         * 企业对公打款银行账户
         * <p>
         * 【注】仅限实名方式为对公账户打款认证时使用
         */
        private String orgBankAccountNum;

    }


    /**
     * 机构实名认证页面配置项
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class OrgAuthPageConfig implements Serializable {

        private static final long serialVersionUID = -2321413259878406064L;

        /**
         * 指定页面中默认选择的机构认证方式：
         * <p>
         * ORG_BANK_TRANSFER - 对公账户打款认证
         * ORG_ALIPAY_CREDIT - 法人快捷认证（必须操作人为法定代表人本人场景才会显示，需要法人支付宝刷脸授权完成认证）
         * ORG_LEGALREP_INVOLVED - 法定代表人认证/法人授权书认证（如操作人为法定代表人本人操作则为法定代表人认证，如非法定代表人本人则为法人授权书认证）
         */
        private String orgDefaultAuthMode;

        /**
         * 设置页面中可选择的机构认证方式，若不传此参数，则可选择全部认证方式
         * <p>
         * ORG_BANK_TRANSFER - 对公账户打款认证
         * ORG_ALIPAY_CREDIT - 法人快捷认证（必须操作人为法定代表人本人场景才会显示，需要法人支付宝刷脸授权完成认证）
         * ORG_LEGALREP_INVOLVED - 法定代表人认证/法人授权书认证（如操作人为法定代表人本人操作则为法定代表人认证，如非法定代表人本人则为法人授权书认证）
         */
        private List<String> orgAvailableAuthModes;

        /**
         * 设置页面中可编辑的信息，不传此参数，页面默认不允许编辑机构信息。
         * <p>
         * orgNum - 机构证件号（如果账号已实名，传了该字段，页面也是不可编辑更改的，因为证件号是唯一标识）
         * legalRepName - 法定代表人姓名
         * orgBankAccountNum - 企业对公打款银行账户
         */
        private List<String> orgEditableFields;

    }

    /**
     * 经办人身份信息
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class TransactorInfo implements Serializable {

        private static final long serialVersionUID = -7604642989087330634L;

        /**
         * 经办人账号ID
         */
        private String psnId;

        /**
         * 经办人账号标识（手机号或邮箱）
         */
        private String psnAccount;

        /**
         * 经办人身份信息
         */
        private PsnInfo psnInfo;

    }


    /**
     * 经办人认证页面设置
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class TransactorAuthPageConfig implements Serializable {

        private static final long serialVersionUID = 6602047079126311113L;

        /**
         * 设置页面中默认选择的实名认证方式，可选值如下：
         * <p>
         * PSN_FACE - 人脸识别认证（默认值）
         * PSN_MOBILE3 - 手机运营商三要素认证
         * PSN_BANKCARD4 - 银行卡四要素认证
         * 【注】使用iframe内嵌集成不支持对接刷脸方式
         */
        private String psnDefaultAuthMode;

        /**
         * 设置页面中可选择的个人认证方式，若不传此参数，则可选择全部认证方式
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
         * name - 个人姓名
         * IDCardNum - 个人证件号
         * mobile - 个人手机号（仅针对实名认证手机号）
         * bankCardNum - 个人银行卡号
         */
        private List<String> psnEditableFields;

    }


    /**
     * 经办人身份信息
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class PsnInfo implements Serializable {


        private static final long serialVersionUID = 2933450392567202566L;
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

}
