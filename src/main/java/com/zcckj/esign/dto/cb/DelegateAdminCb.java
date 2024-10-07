package com.zcckj.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 管理员转授成功通知回调数据
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class DelegateAdminCb implements Serializable {
    private static final long serialVersionUID = -7782590277312754007L;
    /**
     * 通知的业务类型，固定值：DELEGATE_ADMIN
     */
    private String action;
    /**
     * 机构账号ID
     */
    private String orgId;
    /**
     * 旧管理员个人账号ID
     */
    private String adminId;
    /**
     * 新管理员个人账号ID
     */
    private String newAdminId;
    /**
     * 回调通知发送时间（如重试多次均返回第一次时间，毫秒级时间戳格式）
     */
    private Long timestamp;
}
