package com.zcckj.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 个人认证信息（个人认证场景返回此参数）
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class PsnInfo implements Serializable {

    private static final long serialVersionUID = -2810968662604599720L;

    /**
     * 个人账号ID
     */
    private String psnId;


    /**
     * 个人账号信息
     */
    private PsnAccount psnAccount;
}