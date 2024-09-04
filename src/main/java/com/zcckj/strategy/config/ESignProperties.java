package com.zcckj.strategy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * e签宝配置
 *
 * @author zhangjie
 * @date 2024-09-04
 */
@Data
@ConfigurationProperties("esign")
public class ESignProperties {
	/** 接口基础地址*/
    private String baseUrl;
	/** 应用ID*/
    private String appId;
	/** 应用密钥*/
    private String appSecret;
}
