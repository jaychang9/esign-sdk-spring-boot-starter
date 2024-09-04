package com.zcckj.esign.config;

import com.zcckj.esign.config.properties.ESignProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {ESignProperties.class})
public class ESignConfig {

    private ESignProperties eSignProperties;
}
