package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取免登录企业控制台页面响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetOrgConsoleUrlRes implements Serializable {
    private static final long serialVersionUID = -7810649143268975669L;

    /**
     * 机构账号ID
     */
    private String orgConsoleUrl;

}
