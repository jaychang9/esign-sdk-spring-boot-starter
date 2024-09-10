package com.zcckj.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 企业信息变更通知回调数据
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class UpdateOrgNameCb implements Serializable {
    private static final long serialVersionUID = -6851580796968730787L;
    /**
     * 通知的业务类型，固定值：UPDATE_ORG_NAME
     */
    private String action;
    /**
     * 回调通知发送时间（如重试多次均返回第一次时间，毫秒级时间戳格式）
     */
    private String orgId;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 法定代表人姓名
     */
    private String newOrgName;
    /**
     * 回调通知发送时间（如重试多次均返回第一次时间，毫秒级时间戳格式）
     */
    private Long timestamp;
}
