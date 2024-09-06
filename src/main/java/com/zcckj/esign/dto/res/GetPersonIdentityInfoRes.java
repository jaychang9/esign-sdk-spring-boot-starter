package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 查询个人认证信息响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetPersonIdentityInfoRes implements Serializable {
    private static final long serialVersionUID = -1514611405767033434L;

    /**
     * 用户在e签宝的实名认证状态
     * <p>
     * 0 - 未实名，1 - 已实名
     */
    private Integer realnameStatus;

    /**
     * 是否授权相关信息给当前应用
     * <p>
     * true - 已授权，false - 未授权
     */
    private Boolean authorizeUserInfo;

    /**
     * 个人账号ID
     */
    private String psnId;

    /**
     * 个人账号标识
     * <p>
     * 【注】仅当authorizeUserInfo返回值为true，已授权当前应用时，才会返回个人账号标识信息。
     */
    private PsnAccount psnAccount;

    /**
     * 个人用户身份信息
     * <p>
     * 【注】仅当authorizeUserInfo返回值为true，已授权当前应用时，才会返回个人用户的身份信息。
     */
    private PsnInfo psnInfo;

    /**
     * 个人账号标识
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class PsnAccount implements Serializable {

        private static final long serialVersionUID = 9215437498970939723L;

        /**
         * 用户登录e签宝SaaS官网的手机号
         */
        private String accountMobile;

        /**
         * 用户登录e签宝SaaS官网的邮箱地址
         */
        private String accountEmail;

    }

    /**
     * 个人用户身份信息
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class PsnInfo implements Serializable {

        private static final long serialVersionUID = -8796865788378139963L;

        /**
         * 个人用户已认证的姓名
         */
        private String psnName;

        /**
         * 个人国籍（暂无值返回）
         */
        private String psnNationality;

        /**
         * 个人证件号
         */
        private String psnIDCardNum;

        /**
         * 证件类型
         * <p>
         * CRED_PSN_CH_IDCARD - 中国大陆居民身份证
         * <p>
         * CRED_PSN_CH_HONGKONG - 香港来往大陆通行证（回乡证）
         * <p>
         * CRED_PSN_CH_MACAO - 澳门来往大陆通行证（回乡证）
         * <p>
         * CRED_PSN_CH_TWCARD - 台湾来往大陆通行证（台胞证）
         * <p>
         * CRED_PSN_PASSPORT - 护照
         */
        private String psnIDCardType;

        /**
         * 个人用户已认证的银行卡号
         */
        private String bankCardNum;

        /**
         * 个人用户已认证的运营商实名登记手机号或银行卡预留手机号
         */
        private String psnMobile;

    }
}
