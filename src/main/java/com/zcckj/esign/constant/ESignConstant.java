package com.zcckj.esign.constant;

/**
 * 请求e签宝接口请求头名称，值常量
 */
public class ESignConstant {
    public static final String ACCEPT_HEADER_NAME = "Accept";
    public static final String CONTENT_TYPE_HEADER_NAME = "Content-Type";
    public static final String CONTENT_MD5_HEADER_NAME = "Content-MD5";

    public static final String APP_ID_HEADER_NAME = "X-Tsign-Open-App-Id";
    public static final String AUTH_MODE_HEADER_NAME = "X-Tsign-Open-Auth-Mode";
    public static final String SIGNATURE_HEADER_NAME = "X-Tsign-Open-Ca-Signature";
    public static final String TIMESTAMP_HEADER_NAME = "X-Tsign-Open-Ca-Timestamp";


    public static final String DEFAULT_CONTENT_TYPE_HEADER_VALUE = "application/json; charset=UTF-8";
    public static final String DEFAULT_ACCEPT_HEADER_VALUE = "*/*";
    public static final String DEFAULT_AUTH_MODE_HEADER_VALUE = "Signature";

    public static final String CALLBACK_ACTION_KEY = "action";

}
