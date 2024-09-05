package com.zcckj.esign.support;

import lombok.experimental.UtilityClass;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;

@UtilityClass
public class SignatureHelper {
    /***
     * 计算请求签名值
     *
     * @param message 待计算的消息
     * @param secret 密钥
     * @return HmacSHA256计算后摘要值的Base64编码
     * @throws Exception 加密过程中的异常信息
     */
    public String doSignatureBase64(String message, String secret) throws Exception {
        String algorithm = "HmacSHA256";
        Mac hmacSha256;
        String digestBase64 = null;
        try {
            hmacSha256 = Mac.getInstance(algorithm);
            byte[] keyBytes = secret.getBytes("UTF-8");
            byte[] messageBytes = message.getBytes("UTF-8");
            hmacSha256.init(new SecretKeySpec(keyBytes, 0, keyBytes.length, algorithm));
            // 使用HmacSHA256对二进制数据消息Bytes计算摘要
            byte[] digestBytes = hmacSha256.doFinal(messageBytes);
            // 把摘要后的结果digestBytes使用Base64进行编码
            digestBase64 = new String(Base64.encodeBase64(digestBytes), "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            String msg = MessageFormat.format("不支持此算法: {0}", e.getMessage());
            Exception ex = new Exception(msg);
            ex.initCause(e);
            throw ex;
        } catch (UnsupportedEncodingException e) {
            String msg = MessageFormat.format("不支持的字符编码: {0}", e.getMessage());
            Exception ex = new Exception(msg);
            ex.initCause(e);
            throw ex;
        } catch (InvalidKeyException e) {
            String msg = MessageFormat.format("无效的密钥规范: {0}", e.getMessage());
            Exception ex = new Exception(msg);
            ex.initCause(e);
            throw ex;
        }
        return digestBase64;
    }
}
