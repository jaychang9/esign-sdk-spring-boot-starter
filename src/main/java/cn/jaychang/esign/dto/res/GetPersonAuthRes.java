package cn.jaychang.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取个人认证&授权页面链接响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetPersonAuthRes implements Serializable {

    private static final long serialVersionUID = -349002978117725956L;

    /**
     * 个人认证授权长链接（有效期30天）
     * <p>
     * 【注】支持自定义域名，微信小程序H5内嵌场景需要使用长链接
     */
    private String authUrl;

    /**
     * 个人认证授权短链接 （有效期30天）
     */
    private String authShortUrl;

    /**
     * 本次认证授权流程ID（请注意保管流程ID，可用于【查询认证授权流程详情】）
     * https://open.esign.cn/doc/opendoc/auth3/hlrs7s
     */
    private String authFlowId;

}
