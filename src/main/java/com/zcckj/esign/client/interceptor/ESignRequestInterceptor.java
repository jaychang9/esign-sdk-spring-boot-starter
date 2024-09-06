package com.zcckj.esign.client.interceptor;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import com.zcckj.esign.config.properties.ESignProperties;
import com.zcckj.esign.constant.ESignConstant;
import com.zcckj.esign.support.EsignEncryption;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

/**
 * 请求e签宝接口前，打印请求地址、请求头、请求体信息，及对请求参数作签名处理
 *
 * @author zhangjie
 */
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
        // 请求体字符串
        final String bodyStr = bodyToString(oldRequest);
        final String contentMD5 = EsignEncryption.doContentMD5(bodyStr);
        final String method = oldRequest.method();
        final String url = oldRequest.url().toString().replaceFirst(eSignProperties.getBaseUrl(), "");
        final String date = "";
        final String headers = "";

        String waitSignStr = EsignEncryption.appendSignDataString(method, contentMD5, ESignConstant.DEFAULT_ACCEPT_HEADER_VALUE, ESignConstant.DEFAULT_CONTENT_TYPE_HEADER_VALUE, headers, date, url);
        log.debug("待签名字符串拼接:\n{}", waitSignStr);

        // 计算请求签名值
        String reqSignature = "";
        try {
            reqSignature = EsignEncryption.doSignatureBase64(waitSignStr, eSignProperties.getAppSecret());
        } catch (Exception e) {
            log.error("计算请求签名值失败", e);
            throw new RuntimeException(e);
        }

        // 添加公共请求头
        Request newRequest = oldRequest.newBuilder()
                .addHeader(ESignConstant.APP_ID_HEADER_NAME, eSignProperties.getAppId())
                .addHeader(ESignConstant.AUTH_MODE_HEADER_NAME, ESignConstant.DEFAULT_AUTH_MODE_HEADER_VALUE)
                .addHeader(ESignConstant.SIGNATURE_HEADER_NAME, reqSignature)
                .addHeader(ESignConstant.TIMESTAMP_HEADER_NAME, EsignEncryption.timeStamp())
                .addHeader(ESignConstant.ACCEPT_HEADER_NAME, ESignConstant.DEFAULT_ACCEPT_HEADER_VALUE)
                .addHeader(ESignConstant.CONTENT_TYPE_HEADER_NAME, ESignConstant.DEFAULT_CONTENT_TYPE_HEADER_VALUE)
                .addHeader(ESignConstant.CONTENT_MD5_HEADER_NAME, contentMD5)
                .build();

        sb.append("\n");
        sb.append("*********************************************************************");
        sb.append("\n");
        sb.append(String.format("请求url:%s", newRequest.url()));
        sb.append("\n");
        sb.append(String.format("请求头:\n%s", newRequest.headers()));
        sb.append("\n");
        sb.append(String.format("请求体:\n%s", bodyStr));
        sb.append("\n");
        sb.append("*********************************************************************");

        return newRequest;
    }

    private static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            if (Objects.isNull(copy.body())) {
                return "";
            }
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            log.error("获取请求体body失败", e);
            return "";
        }
    }

}
