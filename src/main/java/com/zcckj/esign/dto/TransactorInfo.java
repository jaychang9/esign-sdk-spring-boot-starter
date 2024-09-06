package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 企业/机构经办人信息
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class TransactorInfo implements Serializable {

    private static final long serialVersionUID = -396088728733315657L;

    /**
     * 经办人账号标识，手机号或邮箱
     * <p>
     * 【注】指定orgName时，该参数为必传项，为了保证签署人准确，必须配合psnName（经办人姓名）传入
     */
    private String psnAccount;

    /**
     * 经办人身份信息
     */
    private PersonInfo psnInfo;
}
