package cn.jaychang.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 机构发起方信息
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class OrgInitiator implements Serializable {

    private static final long serialVersionUID = -8615744332806251846L;

    /**
     * 机构账号ID
     * <p>
     * 【注】用户在e签宝注册实名后才有账号ID，账号ID获取方式请使用【查询机构认证信息】接口通过组织机构名称/组织机构证件号进行查询
     * https://open.esign.cn/doc/opendoc/auth3/xxz4tc
     */
    private String orgId;

    /**
     * 机构发起方的经办人（机构发起签署场景，经办人账号ID为必传项）
     */
    private Transactor transactor;

    /**
     * 机构发起方的经办人
     */
    @Data
    @Accessors(chain = true)
    public static class Transactor implements Serializable {

        private static final long serialVersionUID = 5778002584620582561L;

        /**
         * 经办人账号ID
         * <p>
         * 【注】用户在e签宝注册实名后才有账号ID，账号ID获取方式请使用【查询个人认证信息】接口通过个人账号标识（手机号或邮箱）/个人用户的证件号进行查询
         * https://open.esign.cn/doc/opendoc/auth3/vssvtu
         */
        private String psnId;

        /**
         * 经办人姓名
         */
        private String psnName;
    }
}
