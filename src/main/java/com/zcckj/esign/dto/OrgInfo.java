package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 企业/机构信息
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class OrgInfo implements Serializable {
    private static final long serialVersionUID = -6792606224365406350L;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构账号ID
     */
    private String orgId;

}
