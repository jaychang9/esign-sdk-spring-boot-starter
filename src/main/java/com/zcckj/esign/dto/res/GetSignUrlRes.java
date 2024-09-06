package com.zcckj.esign.dto.res;

import java.io.Serializable;

/**
 * 获取签署页面链接响应体
 *
 * @author zhangjie
 */
public class GetSignUrlRes implements Serializable {


    private static final long serialVersionUID = 5532460419140872947L;

    /**
     * 签署短链接（有效期180天）
     */
    private String shortUrl;

    /**
     * 签署长链接（永久有效）
     * <p>
     * 【注】支持自定义域名，微信小程序H5内嵌场景需要使用长链接
     */
    private String url;

}
