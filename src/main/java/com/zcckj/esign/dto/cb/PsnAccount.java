package com.zcckj.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 个人账号信息
 */
@Data
@Accessors(chain = true)
public class PsnAccount implements Serializable {

    private static final long serialVersionUID = -7446984105698796634L;

    /**
     * 手机号（个人账号标识）
     */
    private String accountMobile;

    /**
     * 邮箱号（个人账号标识）
     */
    private String accountEmail;
}