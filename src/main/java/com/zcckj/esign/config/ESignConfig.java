package com.zcckj.esign.config;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitScan;
import com.zcckj.esign.client.interceptor.ESignRequestInterceptor;
import com.zcckj.esign.config.properties.ESignProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RetrofitScan("com.zcckj.esign.client")
@EnableConfigurationProperties(value = {ESignProperties.class})
public class ESignConfig {

    @Bean
    @ConditionalOnMissingBean
    public ESignRequestInterceptor requestInterceptor(ESignProperties eSignProperties) {
        return new ESignRequestInterceptor(eSignProperties);
    }
}
