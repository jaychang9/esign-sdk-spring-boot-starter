package com.zcckj.esign.client.interceptor;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import com.zcckj.esign.config.properties.ESignProperties;
import com.zcckj.esign.support.EsignEncryption;
import com.zcckj.esign.support.SignatureHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class ESignRequestInterceptor extends BasePathMatchInterceptor {

    private final ESignProperties eSignProperties;

    @Override
    protected Response doIntercept(Chain chain) throws IOException {
        Request request = chain.request();
        StringBuilder sb = new StringBuilder();
        Request newRequest = createNewRequest(request, sb);
        if (log.isDebugEnabled()) {
            log.debug(sb.toString());
        }
        return chain.proceed(newRequest);
    }

    private Request createNewRequest(Request oldRequest, StringBuilder sb) {
        long timestamp = System.currentTimeMillis();
        // 请求体字符串
        String bodyStr = bodyToString(oldRequest);
        String contentMD5 = EsignEncryption.doContentMD5(bodyStr);
        String appId = eSignProperties.getAppId();
        String method = oldRequest.method();
        String accept = "*/*";
        String contentType = "application/json; charset=UTF-8";
        String url = oldRequest.url().toString().replaceFirst(eSignProperties.getBaseUrl(), "");
        String date = "";
        String headers = "";

        sb.append(method).append("\n").append(accept).append("\n").append(contentMD5).append("\n")
                .append(contentType).append("\n").append(date).append("\n");
        if ("".equals(headers)) {
            sb.append(headers).append(url);
        } else {
            sb.append(headers).append("\n").append(url);
        }

        log.debug("待签名字符串拼接:\n{}", sb.toString());

        // 计算请求签名值
        String reqSignature = "";
        try {
            reqSignature = SignatureHelper.doSignatureBase64(sb.toString(), eSignProperties.getAppSecret());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 添加公共请求头
        Request newRequest = oldRequest.newBuilder()
                .addHeader("X-Tsign-Open-App-Id", appId)
                .addHeader("X-Tsign-Open-Auth-Mode", "Signature")
                .addHeader("X-Tsign-Open-Ca-Signature", reqSignature)
                .addHeader("X-Tsign-Open-Ca-Timestamp", String.valueOf(timestamp))
                .addHeader("Accept", "*/*")
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .addHeader("Content-MD5", contentMD5)
                .build();
        sb.append("*********************************************************************");
        sb.append(String.format("请求url:%s", newRequest.url()));
        sb.append("\n");
        sb.append(String.format("请求头:\n%s", newRequest.headers()));
        sb.append("\n");
        sb.append(String.format("请求体:\n%s", bodyStr));
        sb.append("*********************************************************************");

        return newRequest;
    }

    private static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            log.error("获取请求体body失败", e);
            return "";
        }
    }

}
