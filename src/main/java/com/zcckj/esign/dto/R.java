package com.zcckj.esign.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * e签宝统一响应结构体
 *
 * @author jaychang
 **/
@Data
public class R<T> implements Serializable {

    public static final Integer SUCCESS_CODE = 0;

    private Integer code;

    private T data;

    private String message;

    public static boolean isSuccess(R<?> result) {
        return result != null && SUCCESS_CODE.equals(result.getCode());
    }
}
