package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取批量签页面链接（多流程）响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetBatchSignUrlRes implements Serializable {

    private static final long serialVersionUID = -7838993178254286077L;

    /**
     * 需登录批量签长链接（链接有效期2小时）
     * <p>
     * 【注】支持自定义域名，微信小程序H5内嵌场景需要使用长链接
     */
    private String batchSignUrl;

    /**
     * 需登录批量签短链接（链接有效期2小时）
     */
    private String batchSignShortUrl;

    /**
     * 免登录批量签长链接（链接有效期2小时）
     * <p>
     * 【注】支持自定义域名，微信小程序H5内嵌场景需要使用长链接
     */
    private String batchSignUrlWithoutLogin;

    /**
     * 免登录批量签短链接（链接有效期2小时）
     */
    private String batchSignShortUrlWithoutLogin;

}
