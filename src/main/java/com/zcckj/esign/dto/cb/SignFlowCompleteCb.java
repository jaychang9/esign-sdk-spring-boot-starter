package com.zcckj.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 流程结束通知
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignFlowCompleteCb implements Serializable {
    private static final long serialVersionUID = 4889674936006665093L;
    /**
     * 标记该通知的业务类型，该通知固定为：SIGN_FLOW_COMPLETE
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
     * 签署流程标题
     */
    private String signFlowTitle;
    /**
     * 签署流程最终状态
     * <p>
     * 2 - 已完成（所有签署方完成签署）
     * <p>
     * 3 - 已撤销（发起方撤销签署任务）
     * <p>
     * 5 - 已过期（签署截止日到期后触发）
     * <p>
     * 7 - 已拒签（签署方拒绝签署）
     */
    private String signFlowStatus;
    /**
     * 当流程非签署完成，其他原因结束时，附加原因描述
     */
    private String statusDescription;
    /**
     * 签署流程创建时间（Unix时间戳格式，单位：毫秒）
     */
    private Long signFlowCreateTime;
    /**
     * 签署流程开启时间（Unix时间戳格式，单位：毫秒）
     */
    private Long signFlowStartTime;
    /**
     * 签署流程完结时间（Unix时间戳格式，单位：毫秒）
     */
    private Long signFlowFinishTime;
}
