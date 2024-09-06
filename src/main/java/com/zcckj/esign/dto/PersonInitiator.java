package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PersonInitiator implements Serializable {
    private static final long serialVersionUID = -3605437186698083104L;

    /**
     * 个人账号ID
     *
     * 【注】用户在e签宝注册实名后才有账号ID，账号ID获取方式请使用【查询个人认证信息】接口通过个人账号标识（手机号或邮箱）/个人用户的证件号进行查询
     *  https://open.esign.cn/doc/opendoc/auth3/vssvtu
     */
    private String psnId;

    /**
     * 个人发起方姓名
     */
    private String psnName;
}
