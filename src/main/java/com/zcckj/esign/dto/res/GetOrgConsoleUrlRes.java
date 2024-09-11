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
     * 免登录企业控制台链接（有效期30分钟，过期需要重新获取）
     */
    private String orgConsoleUrl;

}
