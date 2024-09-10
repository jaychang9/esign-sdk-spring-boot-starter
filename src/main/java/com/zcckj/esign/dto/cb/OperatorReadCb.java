package com.zcckj.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 实名认证通过通知
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class OperatorReadCb implements Serializable {
    private static final long serialVersionUID = 6978114267684275004L;
    /**
     * 标记该通知的业务类型，该通知固定为：AUTH_PASS
     */
    private String action;
    /**
     * 回调通知触发时间，Unix时间戳格式，单位：毫秒
     */
    private Long timestamp;
    /**
     * 签署流程ID
     */
    private String signFlowId;
    /**
     * 自定义业务编号
     *
     * 该参数取值设置签署区的时候设置的customBizNum参数
     */
    private String customBizNum;
    /**
     * 当前签署顺序
     */
    private Integer signOrder;
    /**
     * 已读时间，格式：yyyy-MM-dd HH:mm:ss
     */
    private String readTime;
    /**
     * 签署操作人信息
     */
    private PsnInfo operator;
}
