package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 企业管理员信息
 */
@Data
@Accessors(chain = true)
public class Administrator implements Serializable {
    private static final long serialVersionUID = -5227137900178626310L;

    /**
     * 管理员账号ID
     */
    private String psnId;

    /**
     * 管理员实名姓名
     */
    private String psnName;

    /**
     * 管理员账号标识
     */
    private PsnAccount psnAccount;

    /**
     * 员工编号
     */
    private String employeeNum;

    /**
     * 员工姓名/昵称
     */
    private String memberName;

    /**
     * 个人账号标识（手机号/邮箱）
     */
    @Data
    @Accessors(chain = true)
    public static class PsnAccount implements Serializable {

        private static final long serialVersionUID = 6707558305482286461L;
        /**
         * 管理员手机号（账号标识，用于登录e签宝官网）
         */
        private String accountMobile;

        /**
         * 管理员邮箱地址（账号标识，用于登录e签宝官网）
         */
        private String accountEmail;

    }

}
