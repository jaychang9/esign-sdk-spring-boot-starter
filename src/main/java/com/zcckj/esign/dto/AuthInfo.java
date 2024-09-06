package com.zcckj.esign.dto;

import com.sun.scenario.effect.impl.prism.PrImage;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 认证详情
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class AuthInfo implements Serializable {
    private static final long serialVersionUID = 6013836403930504530L;

    /**
     * 流程中使用的意愿认证方式
     * <p>
     * CODE_SMS - 短信验证码
     * <p>
     * CODE_EMAIL - 邮箱验证码
     * <p>
     * PSN_FACE_ALIPAY - 支付宝刷脸
     * <p>
     * PSN_FACE_TECENT - 腾讯云刷脸
     * <p>
     * PSN_FACE_ESIGN - 快捷刷脸
     * <p>
     * PSN_FACE_WECHAT - 微信小程序刷脸
     */
    private String willingnessAuthModes;

    /**
     * 本次流程中使用的个人/经办人认证方式
     * <p>
     * PSN_BANKCARD4 - 个人银行卡四要素认证
     * <p>
     * PSN_MOBILE3 - 手机运营商三要素认证
     * <p>
     * PSN_BANKCARD4_DETAILS - 个人银行卡四要素认证（详情版）
     * <p>
     * PSN_MOBILE3_DETAILS - 个人运营商三要素认证（详情版）
     * <p>
     * PSN_FACE - 刷脸认证
     */
    private String psnAuthMode;

    /**
     * 本次流程中机构实名认证使用的认证方式
     * <p>
     * ORG_BANK_TRANSFER - 对公账户打款认证
     * <p>
     * ORG_ALIPAY_CREDIT - 企业支付宝认证
     * <p>
     * ORG_LEGALREP_AUTHORIZATION - 授权委托书认证
     * <p>
     * ORG_LEGALREP - 法定代表人本人实名认证
     * <p>
     * ORG_LEGALREP_WILLINGNESS - 法定代表人本人意愿认证
     */
    private String orgAuthMode;

    /**
     * 流程创建时间（Unix时间戳格式，单位：毫秒）
     */
    private Long authFlowCreateTime;

    /**
     * 流程最后更新时间（Unix时间戳格式，单位：毫秒）
     */
    private Long authFlowUpdateTime;

    /**
     * 个人以及机构经办人信息
     * <p>
     * 个人实名认证场景返回个人信息
     * 机构实名认证场景返回经办人信息
     */
    private Person person;

    /**
     * 实名认证的机构信息
     */
    private Organization organization;


    /**
     * 个人或机构经办人信息
     */
    @Data
    @Accessors(chain = true)
    public static class Person implements Serializable {

        private static final long serialVersionUID = 728290292994263783L;

        /**
         * 个人账号ID
         */
        private String psnId;

        /**
         * 个人账号标识（手机号/邮箱）
         */
        private PsnAccount psnAccount;

        /**
         * 个人身份信息
         */
        private PsnInfo psnInfo;

        /**
         * 人脸识别信息
         */
        private FaceRecognitionInfo faceRecognitionInfo;

    }

    /**
     * 个人账号标识（手机号/邮箱）
     */
    @Data
    @Accessors(chain = true)
    public static class PsnAccount implements Serializable {

        private static final long serialVersionUID = 2987375996526920781L;

        /**
         * 手机号（个人账号标识）
         */
        private String accountMobile;

        /**
         * 邮箱（个人账号标识）
         */
        private String accountEmail;

    }

    /**
     * 个人身份信息
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class PsnInfo implements Serializable {


        private static final long serialVersionUID = 8685777746208362569L;
        /**
         * 个人姓名
         */
        private String psnName;

        /**
         * 个人用户已认证的国籍/地区（默认不返回值）
         */
        private String psnNationality;

        /**
         * 个人用户已认证的证件号
         */
        private String psnIDCardNum;

        /**
         * 个人证件类型
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
         * 个人用户已认证的银行卡号
         */
        private String bankCardNum;


        /**
         * 个人用户已认证的运营商实名登记手机号或银行卡预留手机号
         */
        private String psnMobile;

    }


    /**
     * 人脸识别信息
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class FaceRecognitionInfo implements Serializable {

        private static final long serialVersionUID = 48399783773353696L;

        /**
         * 刷脸认证时刷脸照片（base64编码照片图片数据）
         *
         * 补充说明：
         *
         * 此字段默认不返回任何信息，需联系e签宝沟通业务场景通过后才可开通
         * 认证方式仅当选择腾讯云人脸识别、快捷人脸识别或微信小程序刷脸时，才会返回该字段
         * 地址有效期默认1个小时，过期后可以重新调用接口获取新的地址
         */
        private String facePhotoUrl;

        /**
         * 刷脸照片相似度得分
         *
         * 补充说明：
         *
         * 认证方式仅当选择腾讯云人脸识别、快捷人脸识别或微信小程序刷脸时，才会返回该字段
         */
        private String similarityScore;

        /**
         * 刷脸活体检测得分
         *
         * 补充说明：
         *
         * 认证方式仅当选择腾讯云人脸识别、快捷人脸识别或微信小程序刷脸时，才会返回该字段
         */
        private String livingScore;

        /**
         * 刷脸认证时上传的身份证正面照片（base64编码照片图片数据）
         *
         * 补充说明：
         *
         * 此字段默认不返回任何信息，需联系e签宝沟通业务场景通过后才可开通
         * 认证方式仅限微信小程序使用e签宝微信小程序刷脸时，才会返回该字段
         * 地址有效期默认1个小时，过期后可以重新调用接口获取新的地址
         */
        private String idCardFront;

        /**
         * 脸认证时上传的身份证反面照片（base64编码照片图片数据）
         *
         * 补充说明：
         *
         * 此字段默认不返回任何信息，需联系e签宝沟通业务场景通过后才可开通
         * 认证方式仅限微信小程序使用e签宝微信小程序刷脸时，才会返回该字段
         * 地址有效期默认1个小时，过期后可以重新调用接口获取新的地址
         */
        private String idCardBack;


    }


    /**
     * 实名认证的机构信息
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class Organization implements Serializable {

        private static final long serialVersionUID = 9023441188201720124L;

        /**
         * 机构账号ID
         */
        private String orgId;

        /**
         * 组织机构名称（账号标识）
         */
        private String orgName;

        /**
         * 组织机构信息
         */
        private OrgInfo orgInfo;
    }

    /**
     * 组织机构信息
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class OrgInfo implements Serializable {

        private static final long serialVersionUID = -2768085566642703815L;

        /**
         * 组织机构证件号
         */
        private String orgIDCardNum;

        /**
         * 组织机构证件类型
         *
         * CRED_ORG_USCC - 统一社会信用代码
         *
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
         * 法定代表人证件类型
         *
         * CRED_PSN_CH_IDCARD - 中国大陆居民身份证
         *
         * CRED_PSN_CH_HONGKONG - 香港来往大陆通行证
         *
         * CRED_PSN_CH_MACAO - 澳门来往大陆通行证
         *
         * CRED_PSN_CH_TWCARD - 台湾来往大陆通行证
         *
         * CRED_PSN_PASSPORT - 护照
         */
        private String legalRepIDCardType;

    }

}
