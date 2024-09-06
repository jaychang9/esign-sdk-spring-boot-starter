package com.zcckj.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 撤销签署流程请求体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignFlowRevokeReq implements Serializable {
    private static final long serialVersionUID = -4093892956745586519L;

    /**
     * 撤销原因
     * <p>
     * 补充说明：
     * <p>
     * 撤销原因最多50字
     * 撤销原因不可含有以下9个特殊字符：/ \ : * " < > | ？以及所有emoji表情
     */
    private String revokeReason;
}
