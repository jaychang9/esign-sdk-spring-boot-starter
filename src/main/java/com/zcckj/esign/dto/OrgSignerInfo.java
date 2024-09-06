package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 企业/机构签署方信息
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class OrgSignerInfo implements Serializable {
    private static final long serialVersionUID = -3864777468848590494L;
    /**
     * 企业/机构名称（账号标识）
     * <p>
     * 【注】企业/机构用户签署时，该参数为必传项
     */
    private String orgName;

    /**
     * 企业/机构签署方信息（将展示在机构认证页面）
     */
    private OrgInfo orgInfo;

    /**
     * 企业/机构经办人信息
     * <p>
     * 企业/机构手动签署（autoSign为false），经办人信息必传
     * 企业/机构自动落章（autoSign为true），请不要传该参数
     */
    private TransactorInfo transactorInfo;
}
