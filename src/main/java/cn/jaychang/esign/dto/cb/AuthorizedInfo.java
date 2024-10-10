package cn.jaychang.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 授权信息
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class AuthorizedInfo implements Serializable {
    private static final long serialVersionUID = 4054857953009704510L;
    /**
     * 授权范围
     * <p>
     * 授权主体为个人用户（企业授权场景为经办人）：
     * <p>
     * get_psn_identity_info - 授权允许获取个人账号基本信息
     * <p>
     * psn_initiate_sign - 授权允许代替用户发起合同签署
     * <p>
     * manage_psn_resource -授权允许获取用户的模板、印章等资源的权限
     * <p>
     * 授权主体为企业机构用户：
     * <p>
     * get_org_identity_info - 授权允许获取机构用户账号基本信息
     * <p>
     * org_initiate_sign - 授权允许代替机构用户发起合同签署
     * <p>
     * manage_org_resource - 授权允许获取机构用户的模板、印章、组织成员等资源的权限
     * <p>
     * use_org_order - 授权允许获取机构用户套餐订单的使用权限
     */
    private String authorizedScope;
    /**
     * 授权生效时间（unix时间戳，单位：毫秒）
     */
    private Long effectiveTime;
    /**
     * 授权失效时间（unix时间戳，单位：毫秒）
     */
    private Long expireTime;
}
