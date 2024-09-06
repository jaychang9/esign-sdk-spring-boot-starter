package com.zcckj.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 查询个人认证信息请求体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetPersonIdentityInfoReq implements Serializable {
    private static final long serialVersionUID = -1514611405767033434L;

    /**
     * 个人账号ID
     */
    private String psnId;

    /**
     * 个人账号标识（手机号或邮箱）
     */
    private String psnAccount;

    /**
     * 个人用户的证件号
     */
    private String psnIDCardNum;

    /**
     * 个人证件号类型 （传psnIDCardNum时，证件类型为必传项）
     * <p>
     * CRED_PSN_CH_IDCARD - 中国大陆居民身份证
     * <p>
     * CRED_PSN_CH_HONGKONG - 香港来往大陆通行证
     * <p>
     * CRED_PSN_CH_MACAO - 澳门来往大陆通行证
     * <p>
     * CRED_PSN_CH_TWCARD - 台湾来往大陆通行证
     * <p>
     * CRED_PSN_PASSPORT - 护照
     * <p>
     * 响应参数
     */
    private String psnIDCardType;
}
