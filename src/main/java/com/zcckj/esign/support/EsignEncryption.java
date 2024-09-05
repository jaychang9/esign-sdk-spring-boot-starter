/*
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.zcckj.esign.support;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.*;

/**
 * @author 澄泓
 * @description 请求数据通用处理类
 * @date 2020年10月22日 下午14:25:31
 * @since JDK1.7
 */
public class EsignEncryption {

    /**
     * 不允许外部创建实例
     */
    private EsignEncryption() {
    }

    /**
     * 拼接待签名字符串
     *
     * @param httpMethod
     * @param url
     * @return
     */
    public static String appendSignDataString(String httpMethod, String contentMd5, String accept, String contentType, String headers, String date, String url) throws ESignException {
        StringBuffer sb = new StringBuffer();
        sb.append(httpMethod).append("\n").append(accept).append("\n").append(contentMd5).append("\n")
                .append(contentType).append("\n");

        if ("".equals(date) || date == null) {
            sb.append("\n");
        } else {
            sb.append(date).append("\n");
        }
        if ("".equals(headers) || headers == null) {
            sb.append(url);
        } else {
            sb.append(headers).append("\n").append(url);
        }
        return new String(sb);
    }

    /***
     *  Content-MD5的计算方法
     * @param str 待计算的消息
     * @return MD5计算后摘要值的Base64编码(ContentMD5)
     * @throws ESignException 加密过程中的异常信息
     */
    public static String doContentMD5(String str) throws ESignException {
        byte[] md5Bytes = null;
        MessageDigest md5 = null;
        String contentMD5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md5.update(str.getBytes("UTF-8"));
            // 获取文件MD5的二进制数组（128位）
            md5Bytes = md5.digest();
            // 把MD5摘要后的二进制数组md5Bytes使用Base64进行编码（而不是对32位的16进制字符串进行编码）
            contentMD5 = Base64.encodeBase64String(md5Bytes);

        } catch (NoSuchAlgorithmException e) {
            ESignException ex = new ESignException("不支持此算法", e);
            ex.initCause(e);
            throw ex;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return contentMD5;
    }

    /***
     * 计算请求签名值-HmacSHA256摘要
     * @param message 待签名字符串
     * @param secret  密钥APP KEY
     * @return reqSignature HmacSHA256计算后摘要值的Base64编码
     * @throws ESignException 加密过程中的异常信息
     */
    public static String doSignatureBase64(String message, String secret) throws ESignException {
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
            digestBase64 = Base64.encodeBase64String(digestBytes);
        } catch (NoSuchAlgorithmException e) {
            ESignException ex = new ESignException("不支持此算法", e);
            ex.initCause(e);
            throw ex;
        } catch (InvalidKeyException e) {
            ESignException ex = new ESignException("无效的密钥规范", e);
            ex.initCause(e);
            throw ex;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return digestBase64;
    }

    /**
     * 获取时间戳
     *
     * @return
     */
    public static String timeStamp() {
        long timeStamp = System.currentTimeMillis();
        return String.valueOf(timeStamp);
    }

    /**
     * byte字节数组转换成字符串
     *
     * @param b
     * @return
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }

    /**
     * hash散列加密算法
     *
     * @return
     */
    public static String Hmac_SHA256(String message, String key) throws ESignException {
        byte[] rawHmac = null;
        try {
            SecretKeySpec sk = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(sk);
            rawHmac = mac.doFinal(message.getBytes());
        } catch (InvalidKeyException e) {
            ESignException ex = new ESignException("无效的密钥规范", e);
            ex.initCause(e);
            throw ex;
        } catch (NoSuchAlgorithmException e) {
            ESignException ex = new ESignException("不支持此算法", e);
            ex.initCause(e);
            throw ex;
        } catch (Exception e) {
            ESignException ex = new ESignException("hash散列加密算法报错", e);
            ex.initCause(e);
            throw ex;
        } finally {
            return byteArrayToHexString(rawHmac);
        }

    }

    /**
     * MD5加密32位
     */
    public static String MD5Digest(String text) throws ESignException {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(text.getBytes());
            digest = md5.digest();
        } catch (NoSuchAlgorithmException e) {
            ESignException ex = new ESignException("不支持此算法", e);
            ex.initCause(e);
            throw ex;
        } finally {
            return byteArrayToHexString(digest);
        }

    }

    /***
     * 字符串是否为空（含空格校验）
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        if (null == str || 0 == str.length()) {
            return true;
        }

        int strLen = str.length();

        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /***
     * 对请求URL中的Query参数按照字段名的 ASCII 码从小到大排序（字典排序）
     *
     * @param apiUrl
     * @return 排序后的API接口地址
     * @throws Exception
     */
    public static String sortApiUrl(String apiUrl) throws ESignException {

        if (!apiUrl.contains("?")) {
            return apiUrl;
        }

        int queryIndex = apiUrl.indexOf("?");
        String apiUrlPath = apiUrl.substring(0, queryIndex + 1);
        String apiUrlQuery = apiUrl.substring(queryIndex + 1);
        //apiUrlQuery为空时返回
        if (isBlank(apiUrlQuery)) {
            return apiUrl.substring(0, apiUrl.length() - 1);
        }
        // 请求URL中Query参数转成Map
        Map<Object, Object> queryParamsMap = new HashMap<Object, Object>();
        String[] params = apiUrlQuery.split("&");
        for (String str : params) {
            int index = str.indexOf("=");
            String key = str.substring(0, index);
            String value = str.substring(index + 1);
            if (queryParamsMap.containsKey(key)) {
                String msg = MessageFormat.format("请求URL中的Query参数的{0}重复", key);
                throw new ESignException(msg);
            }
            queryParamsMap.put(key, value);
        }

        ArrayList<String> queryMapKeys = new ArrayList<String>();
        for (Map.Entry<Object, Object> entry : queryParamsMap.entrySet()) {
            queryMapKeys.add((String) entry.getKey());
        }
        // 按照字段名的 ASCII 码从小到大排序（字典排序）
        Collections.sort(queryMapKeys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.compareToIgnoreCase(o2) == 0 ? -o1.compareTo(o2) : o1.compareToIgnoreCase(o2));
            }
        });

        StringBuffer queryString = new StringBuffer();
        // 构造Query参数键值对值对的格式
        for (int i = 0; i < queryMapKeys.size(); i++) {
            String key = queryMapKeys.get(i);
            String value = (String) queryParamsMap.get(key);
            queryString.append(key);
            queryString.append("=");
            queryString.append(value);
            queryString.append("&");
        }
        if (queryString.length() > 0) {
            queryString = queryString.deleteCharAt(queryString.length() - 1);
        }

        // Query参数排序后的接口请求地址
        StringBuffer sortApiUrl = new StringBuffer();
        sortApiUrl.append(apiUrlPath);
        sortApiUrl.append(queryString.toString());
        return sortApiUrl.toString();
    }

    /***
     * 将byte[]转成16进制字符串
     *
     * @param data
     *
     * @return 16进制字符串
     */
    public static String byte2hex(byte[] data) {
        StringBuilder hash = new StringBuilder();
        String stmp;
        for (int n = 0; data != null && n < data.length; n++) {
            stmp = Integer.toHexString(data[n] & 0XFF);
            if (stmp.length() == 1)
                hash.append('0');
            hash.append(stmp);
        }
        return hash.toString();
    }

}
