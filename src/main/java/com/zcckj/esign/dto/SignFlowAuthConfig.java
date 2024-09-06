package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 流程整体认证配置项
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignFlowAuthConfig implements Serializable {

    private static final long serialVersionUID = 6665884933563979484L;

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
     * 智能视频认证模板ID，请联系交付顾问提供
     */
    private String audioVideoTemplateId;

}
