package com.zcckj.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 授权完成通知
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class AuthorizeFinishCb implements Serializable {
    private static final long serialVersionUID = 5636771462323773298L;
    /**
     * 通知的业务类型，固定值：AUTHORIZE_FINISH
     */
    private String action;
    /**
     * 回调通知发送时间，Unix时间戳（毫秒）
     */
    private Long timestamp;
    /**
     * 个人账号ID（经办人账号ID）
     */
    private String psnId;
    /**
     * 机构账号ID
     */
    private String orgId;
    /**
     * 用户认证&授权流程ID
     */
    private String authFlowId;
    /**
     * 用户授权信息
     */
    List<AuthorizedInfo> authorizedInfo;
    /**
     * 本次操作的机构经办人是否为企业法人
     * <p>
     * true - 是
     * <p>
     * false - 否
     */
    private Boolean legalRepCheck;
    /**
     * 本次操作的机构经办人是否为企业管理员
     * <p>
     * true - 是
     * <p>
     * false - 否
     */
    private Boolean adminCheck;
    /**
     * 本次操作的机构经办人是否获得了用印权限（经办人未成为企业管理员或法人的情况下存在）
     * <p>
     * true - 是
     * <p>
     * false - 否
     */
    private Boolean transactorUseSeal;

}
