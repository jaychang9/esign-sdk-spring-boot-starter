package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 签署流程的发起方
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignFlowInitiator implements Serializable {

    private static final long serialVersionUID = -8561257001794078489L;
    /**
     * 机构发起方信息
     */
    private OrgInitiator orgInitiator;

    /**
     * 个人发起方信息
     */
    private PersonInitiator psnInitiator;

}
