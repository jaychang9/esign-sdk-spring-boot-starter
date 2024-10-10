package cn.jaychang.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 实名认证通过通知
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class AuthPassCb implements Serializable {
    private static final long serialVersionUID = 8167091958694244821L;

    /**
     * 标记该通知的业务类型，该通知固定为：AUTH_PASS
     */
    private String action;
    /**
     * 用户认证&授权流程ID
     */
    private String authFlowId;
    /**
     * 回调通知发送时间（如重试多次均返回第一次时间，毫秒级时间戳格式）
     */
    private Long timestamp;
    /**
     * 认证主体类型
     * <p>
     * PSN - 个人认证，ORG - 机构认证
     */
    private String authType;
    /**
     * 业务类型
     * <p>
     * REAL_NAME - 实名认证
     * <p>
     * UPDATE-INFO - 信息变更（只有企业更名，且之前已经实名的情况可能触发）
     */
    private String bizType;

    /**
     * 个人认证信息（个人认证场景返回此参数）
     */
    private PsnInfo psnInfo;
    /**
     * 机构认证信息
     */
    private Organization organization;


}
