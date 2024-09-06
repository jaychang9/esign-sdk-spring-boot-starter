package com.zcckj.esign.dto;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 重定向配置
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class RedirectConfig implements Serializable {
    /**
     * 签署完成后跳转页面（除app和小程序端集成外，地址需符合 https /http 协议地址）
     * <p>
     * 【注】贵司的重定向域名需要在e签宝提前放行，否则会报错：“您即将访问的页面可能有安全风险”。（点击跳转 重定向域名配置说明）
     * https://open.esign.cn/doc/opendoc/dev-guide3/umo8rop7dmttkdnv
     */
    private String redirectUrl;

    /**
     * 操作完成重定向跳转延迟时间，单位秒（可选值0、3，默认值为 3）
     *
     * 传0时，签署完成直接跳转重定向地址；
     * 传3时，展示签署完成结果页，倒计时3秒后，自动跳转重定向地址。
     * 【注】当redirectUrl不传的情况下，该字段无需传入，签署完成不跳转
     */
    private Integer redirectDelayTime;
}