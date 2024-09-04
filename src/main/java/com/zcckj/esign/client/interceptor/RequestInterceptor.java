package com.zcckj.esign.client.interceptor;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import com.zcckj.esign.config.properties.ESignProperties;
import lombok.RequiredArgsConstructor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class RequestInterceptor extends BasePathMatchInterceptor {

    private final long validDurationMillis = 5 * 60 * 1000;

    private final ESignProperties eSignProperties;

    @Override
    protected Response doIntercept(Chain chain) throws IOException {
        Request request = chain.request();
        long currentTimeMillis = System.currentTimeMillis();
        Request newRequest = createNewRequest(request, currentTimeMillis + validDurationMillis);
        return chain.proceed(newRequest);
    }

    private Request createNewRequest(Request oldRequest, long expireTimeMillis) {
        long timestamp = System.currentTimeMillis();
        // 请求签名值
        String sign = createSign(expireTimeMillis);

        // 添加公共请求头
        Request newRequest = oldRequest.newBuilder()
                .addHeader("X-Tsign-Open-App-Id", eSignProperties.getAppId())
                .addHeader("X-Tsign-Open-Auth-Mode", "Signature")
                .addHeader("X-Tsign-Open-Ca-Signature", "")
                .addHeader("X-Tsign-Open-Ca-Timestamp", String.valueOf(timestamp))
                .addHeader("Accept", "*/*")
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .addHeader("Content-MD5", "")
                .build();
        return newRequest;
    }

    private String createSign(long expireTimeMillis) {
        String content = "";
        String sign = "";
        try {
            sign = DigestUtils.md5DigestAsHex(content.getBytes(StandardCharsets.UTF_8.toString()));
        } catch (UnsupportedEncodingException e) {
            return "";
        }
        return sign;
    }
}
