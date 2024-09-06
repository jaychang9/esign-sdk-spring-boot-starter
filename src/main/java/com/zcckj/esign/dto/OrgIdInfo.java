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
public class OrgIdInfo implements Serializable {
    private static final long serialVersionUID = -6792606224365406350L;
    /**
     * 企业/机构证件号
     */
    private String orgIDCardNum;
    /**
     * 企业/机构证件类型，可选值如下：
     *
     * CRED_ORG_USCC - 统一社会信用代码
     *
     * CRED_ORG_REGCODE - 工商注册号
     */
    private String orgIDCardType;

}
