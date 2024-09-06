package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 查询机构认证信息响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetOrgIdentityInfoRes implements Serializable {
    private static final long serialVersionUID = -446075738916834601L;

    /**
     * 实名认证状态
     * <p>
     * 0 - 未实名，1 - 已实名
     */
    private Integer realnameStatus;

    /**
     * 是否授权身份信息给当前应用
     * <p>
     * true - 已授权，false - 未授权
     */
    private Boolean authorizeUserInfo;

    /**
     * 机构账号ID
     */
    private String orgId;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构认证信息
     * <p>
     * 【注】如果机构已实名的状态下，会默认返回实名的机构名称、机构证件号、机构证件号类型、法定代表人姓名、机构管理员姓名（脱敏）、机构管理员联系方式（脱敏）
     */
    private OrgInfo orgInfo;

    @Data
    @Accessors(chain = true)
    private static class OrgInfo implements Serializable {

        private static final long serialVersionUID = 6966925582883726127L;

        /**
         * 组织机构证件号
         */
        private String orgIDCardNum;

        /**
         * 组织机构证件号类型
         * <p>
         * CRED_ORG_USCC - 统一社会信用
         * <p>
         * CRED_ORG_REGCODE - 工商注册号
         */
        private String orgIDCardType;

        /**
         * 法定代表人姓名
         */
        private String legalRepName;

        /**
         * 法定代表人证件号
         */
        private String legalRepIDCardNum;

        /**
         * 法定代表人证件类型
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
        private String legalRepIDCardType;

        /**
         * 机构管理员姓名（在e签宝SaaS官网认证绑定的管理员姓名）
         * <p>
         * 【注】姓名会脱敏显示
         */
        private String adminName;

        /**
         * 机构管理员联系方式（在e签宝SaaS官网认证绑定的管理员手机号或者邮箱，如果两种联系方式都有优先返回手机号）
         * <p>
         * 【注】联系方式会脱敏显示
         */
        private String adminAccount;
    }

}
