package cn.jaychang.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 签署方-签署结果通知
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignMissionCompleteCb implements Serializable {
    private static final long serialVersionUID = 2021853966436159200L;
    /**
     * 标记该通知的业务类型，该通知固定：SIGN_MISSON_COMPLETE
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
     * 自定义业务编号，该参数取发起签署时添加签署区时设置的customBizNum参数
     * <p>
     * 注：当同一个签署方存在多个签署区且指定不同的该参数值时，该参数会返回多个值，并以逗号分隔
     */
    private String customBizNum;
    /**
     * 签署人的签署顺序
     */
    private Integer signOrder;
    /**
     * 签署时间或拒签时间（Unix时间戳格式，单位：毫秒）
     */
    private Long operateTime;
    /**
     * 签署结果
     * <p>
     * 2 - 签署完成，4 - 拒签
     */
    private Integer signResult;
    /**
     * 拒签或失败时，附加的原因描述
     */
    private String resultDescription;
    /**
     * 操作人信息
     */
    private PsnInfo operator;
    /**
     * 机构签署方
     */
    private Organization organization;
}
