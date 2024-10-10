package cn.jaychang.esign.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * e签宝对接配置
 *
 * @author zhangjie
 * @date 2024-09-04
 */
@Data
@ConfigurationProperties("esign")
public class ESignProperties {
    /**
     * e签宝请求接口地址
     */
    private String baseUrl = "https://smlopenapi.esign.cn";
    /**
     * 应用ID
     */
    private String appId;
    /**
     * 应用密钥
     */
    private String appSecret;

    /**
     * 回调Url(可以不用)
     */
    private String callbackUrl;
}
