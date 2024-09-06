package com.zcckj.esign.dto.req;

import com.zcckj.esign.dto.AuthorizeConfig;
import com.zcckj.esign.dto.PersonAuthConfig;
import com.zcckj.esign.dto.RedirectConfig;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取个人认证&授权页面链接请求体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetPersonAuthReq implements Serializable {
    private static final long serialVersionUID = 4734908842273342822L;

    /**
     * 个人实名认证配置项
     * <p>
     * （如果不传个人的账号信息，则需要个人用户自主在页面填写手机号/邮箱进行验证码回填注册）
     */
    private PersonAuthConfig psnAuthConfig;

    /**
     * 个人授权配置项
     * <p>
     * 授权过期需重新授权；
     * 不传此参数默认页面仅实名认证，不需要用户授权。
     */
    private AuthorizeConfig authorizeConfig;


    /**
     * 认证完成重定向配置项
     */
    private RedirectConfig redirectConfig;

    /**
     * 接收回调通知的Web地址，通知开发者用户认证和授权的完成以及变更情况，
     * <p>
     * 点此了解更多认证授权回调通知。
     * https://open.esign.cn/doc/opendoc/notify3/naksvv
     */
    private String notifyUrl;

    /**
     * 指定客户端类型，默认值 ALL（注意参数值全部为英文大写）
     * <p>
     * ALL - 自动适配移动端或PC端
     * <p>
     * H5 - 移动端适配
     * <p>
     * PC - PC端适配
     */
    private String clientType;

    /**
     * AppScheme，主要用于支付宝人脸认证重定向时跳回开发者自身App。
     * <p>
     * 示例值：esign://demo/realBack
     * <p>
     * （点击了解 APP内嵌签署/认证H5对接说明）
     * https://open.esign.cn/doc/opendoc/case3/ovb0e40do4fnrr61
     */
    private String appScheme;
}
