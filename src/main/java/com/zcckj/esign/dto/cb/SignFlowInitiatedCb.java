package com.zcckj.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 签署发起成功通知
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignFlowInitiatedCb implements Serializable {
    private static final long serialVersionUID = 5587818988591411331L;
    /**
     * 标记该通知的业务类型，该通知固定：SIGN_FLOW_INITIATED
     */
    private String action;
    /**
     * 回调通知触发时间（如重试多次均返回第一次时间，毫秒级时间戳格式）
     */
    private Long timestamp;
    /**
     * 签署流程ID
     */
    private String signFlowId;
    /**
     * 自定义业务编号，取值【通过页面发起签署】中的customBizNum参数
     */
    private String customBizNum;
}
}
