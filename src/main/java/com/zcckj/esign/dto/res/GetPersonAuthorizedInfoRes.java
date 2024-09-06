package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 查询个人授权信息响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetPersonAuthorizedInfoRes implements Serializable {

    private static final long serialVersionUID = 8885122671532991282L;

    /**
     * 用户授权信息列表
     */
    private List<AuthorizedInfo> authorizedInfo;

    /**
     * 用户授权信息
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class AuthorizedInfo implements Serializable {

        private static final long serialVersionUID = 3839072674799098593L;

        /**
         * 用户授权范围
         * <p>
         * get_psn_identity_info - 授权允许获取个人用户的账号基本信息
         * <p>
         * psn_initiate_sign - 授权允许代表个人用户发起合同签署
         * <p>
         * manage_psn_resource - 授权允许获取个人用户的印章等资源的管理权限
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
}
