package cn.jaychang.esign.dto;

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

    public boolean isSuccess() {
        return SUCCESS_CODE.equals(code);
    }

    @Override
    public String toString() {
        return String.format("{\"code\":%d,\"message\":\"%s\"}", code, message);
    }
}
