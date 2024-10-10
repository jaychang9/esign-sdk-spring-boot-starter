package cn.jaychang.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户/机构授权信息
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class AuthorizedInfo implements Serializable {

    private static final long serialVersionUID = 3839072674799098593L;

    /**
     * 用户授权范围
     * <p>
     * get_psn_identity_info - 授权允许获取个人用户的账号基本信息
     * <p>
     * psn_initiate_sign - 授权允许代表个人用户发起合同签署
     * <p>
     * manage_psn_resource - 授权允许获取个人用户的印章等资源的管理权限
     * <p>
     * <p>
     * 机构用户授权范围
     * <p>
     * get_org_identity_info - 授权允许获取机构以及经办人的账号基本信息
     * <p>
     * org_initiate_sign - 授权允许代表机构用户发起合同签署
     * <p>
     * manage_org_resource - 授权允许获取机构用户的模板、印章、组织成员等资源的权限
     * <p>
     * use_org_order - 授权允许获取机构用户套餐订单的使用权限
     */
    private String authorizedScope;

    /**
     * 授权生效时间（Unix时间戳格式，单位毫秒）
     */
    private Long effectiveTime;

    /**
     * 授权到期时间（Unix时间戳格式，单位毫秒）
     */
    private Long expireTime;

}