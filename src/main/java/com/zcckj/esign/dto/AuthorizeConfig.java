package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 个人授权配置项
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class AuthorizeConfig implements Serializable {

    private static final long serialVersionUID = 8995824729403779988L;

    /**
     * 设置页面中权限范围，参数值如下：
     *
     * 授权当前应用AppId获取用户的账号基本信息：
     *
     * get_psn_identity_info - 授权允许获取个人用户的账号信息（姓名、手机号/邮箱、证件号等）
     * 授权当前应用AppId代用户发起合同签署：
     *
     * psn_initiate_sign - 授权允许代表个人用户发起合同签署以及查询合同签署详情
     * 授权当前应用AppId获取用户资源管理权限：
     *
     * manage_psn_resource - 授权允许获取个人用户的印章等资源的管理权限
     * 授权当前应用AppId存储用户的合同文件：
     *
     * （用于平台专属云项目代客户发起合同签署场景）
     *
     * psn_sign_file_storage - 授权个人合同文件存储到平台应用的本地服务器
     */
    private List<String> authorizedScopes;
}
