package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 签署方维度认证配置项
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignerAuthConfig implements Serializable {
    private static final long serialVersionUID = -4369590832960142447L;


    /**
     * 签署意愿认证方式，可选值如下：
     * <p>
     * CODE_SMS - 短信验证码
     * PSN_FACE_ALIPAY - 支付宝刷脸
     * PSN_FACE_ESIGN - 快捷刷脸
     * PSN_FACE_WECHAT - 微信小程序刷脸（仅限微信小程序中使用）
     * SIGN_PWD - 签署密码
     * 以下方式如需使用，请联系交付顾问开通：
     * <p>
     * PSN_FACE_TECENT - 腾讯云刷脸
     * PSN_AUDIO_VIDEO_ALIPAY - 支付宝智能视频认证
     * PSN_AUDIO_VIDEO_WECHAT - 微信智能视频认证
     * 【注】使用iframe内嵌集成不支持对接刷脸方式
     */
    private List<String> willingnessAuthModes;

    /**
     * 个人实名认证方式，可选值：
     * <p>
     * PSN_MOBILE3 - 个人运营商三要素认证
     * PSN_FACE - 刷脸认证
     * PSN_BANKCARD4 - 个人银行卡四要素认证
     * 【注】使用iframe内嵌集成不支持对接刷脸方式
     */
    private List<String> psnAvailableAuthModes;

    /**
     * 机构实名认证方式，可选值：
     * <p>
     * ORG_BANK_TRANSFER - 对公打款认证
     * ORG_ALIPAY_CREDIT - 法人快捷认证（必须操作人为法定代表人本人场景才会显示，需要法人支付宝刷脸授权完成认证）
     * ORG_LEGALREP_AUTHORIZATION - 法人授权认证（必须操作人 非法定代表人本人场景才会显示，会通知法人在线签署授权书，授权给操作人）
     * ORG_LEGALREP - 法定代表人认证（必须操作人为法定代表人本人场景才会显示，法人任选一种个人认证方式完成认证）
     */
    private List<String> orgAvailableAuthModes;

    /**
     * 是否需要意愿认证，默认：true
     * <p>
     * true - 需要
     * <p>
     * false - 不需要（仅限海外签时可配置，signMode=GLOBAL）
     */
    private Boolean globalWillingness;

    /**
     * 海外签身份验证方式，默认：MAINLAND_REAL_NAME
     * <p>
     * MAINLAND_REAL_NAME - 中国实名（中国大陆签原有方式）
     * <p>
     * NO_NEED - 无需验证（仅限海外签时可配置，signMode=GLOBAL）
     * <p>
     * ACCESS_CODE - 访问口令（仅限海外签时可配置，signMode=GLOBAL；且配置该方式时，globalAccessCode必须传值）
     */
    private String globalAuthModes;

    /**
     * 海外签访问口令（仅限海外签时可配置，signMode=GLOBAL）
     * <p>
     * 【注】支持6-45位，只支持字母和数字
     */
    private String globalAccessCode;
}
