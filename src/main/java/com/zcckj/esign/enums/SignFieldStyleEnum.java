package com.zcckj.esign.enums;

import lombok.AllArgsConstructor;

/**
 * 签章区样式
 */
@AllArgsConstructor
public enum SignFieldStyleEnum {
    SINGLE_PAGE(1, "单页签章"),
    CROSS_PAGE(2, "骑缝签章");

    private final Integer code;
    private final String name;
}
