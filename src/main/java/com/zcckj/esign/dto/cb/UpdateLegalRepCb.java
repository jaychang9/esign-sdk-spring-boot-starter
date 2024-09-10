package com.zcckj.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 法定代表人信息变更通知
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class UpdateLegalRepCb implements Serializable {
    private static final long serialVersionUID = -8578926714781499991L;
    /**
     * 通知的业务类型，固定值：UPDATE_LEGAL_REP
     */
    private String action;
    /**
     * 机构账号ID
     */
    private String orgId;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 法定代表人姓名
     */
    private String legalRepName;
    /**
     * 法定代表人证件类型
     * <p>
     * CRED_PSN_CH_IDCARD - 中国大陆居民身份证（默认值）
     * CRED_PSN_CH_HONGKONG - 香港来往大陆通行证（回乡证）
     * CRED_PSN_CH_MACAO - 澳门来往大陆通行证（回乡证）
     * CRED_PSN_CH_TWCARD - 台湾来往大陆通行证（台胞证）
     * CRED_PSN_PASSPORT - 护照
     * 注：【获取机构认证&授权页面链接】接口指定授权范围：get_org_identity_info 才会返回该字段
     * https://open.esign.cn/doc/opendoc/auth3/kcbdu7
     */
    private String legalRepIDCardType;
    /**
     * 法定代表人证件号
     * <p>
     * 注：【获取机构认证&授权页面链接】接口指定授权范围：get_org_identity_info 才会返回该字段
     * https://open.esign.cn/doc/opendoc/auth3/kcbdu7
     */
    private String legalRepIDCardNum;
    /**
     * 回调通知发送时间（如重试多次均返回第一次时间，毫秒级时间戳格式）
     */
    private Long timestamp;
}
