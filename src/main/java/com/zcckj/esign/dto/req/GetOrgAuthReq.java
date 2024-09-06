package com.zcckj.esign.dto.req;

import com.zcckj.esign.dto.AuthorizeConfig;
import com.zcckj.esign.dto.OrgAuthConfig;
import com.zcckj.esign.dto.PersonAuthConfig;
import com.zcckj.esign.dto.RedirectConfig;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取机构认证&授权页面链接请求体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetOrgAuthReq implements Serializable {

    private static final long serialVersionUID = 5137141001985183487L;

    /**
     * 组织机构认证配置项
     *
     * 组织机构名称orgName与机构账号orgId二者选一项传入即可；
     * 如已实名，则页面需进行意愿认证。
     */
    private OrgAuthConfig orgAuthConfig;

    /**
     * 机构授权配置项
     *
     * 授权过期需重新授权；
     * 不传此参数默认页面仅实名认证，不需要用户授权。
     */
    private AuthorizeConfig authorizeConfig;

    /**
     * 认证完成重定向配置项
     */
    private RedirectConfig redirectConfig;

    /**
     * 当前经办人非企业管理员的情况下，是否需要为其获取企业全部印章的用印权限，默认false
     *
     * true - 需要
     *
     * false - 不需要
     *
     * 补充说明：
     *
     * 只在配置了authorizeConfig的授权模式下生效，纯实名模式不生效
     * 第一次为企业做实名的经办人会变成企业管理员，则不需要再额外获取用印权限
     */
    private Boolean transactorUseSeal;


    /**
     * 指定客户端类型，默认值 ALL（注意参数值全部为英文大写）
     *
     * ALL - 自动适配移动端或PC端
     * H5 - 移动端适配
     * PC - PC端适配
     */
    private String clientType;

    /**
     * 接收回调通知的Web地址（需符合 https /http 协议），通知开发者用户认证和授权的完成情况，点击详见通知说明
     */
    private String notifyUrl;

    /**
     * AppScheme，用于支付宝人脸认证重定向时唤起指定App。
     *
     * 示例值：esign://demo/realBack
     *
     * （点击了解 APP内嵌签署/认证H5对接说明）
     *  https://open.esign.cn/doc/opendoc/case3/ovb0e40do4fnrr61
     */
    private String appScheme;
}
