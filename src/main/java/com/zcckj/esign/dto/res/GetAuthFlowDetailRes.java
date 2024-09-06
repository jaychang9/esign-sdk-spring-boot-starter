package com.zcckj.esign.dto.res;

import com.zcckj.esign.dto.AuthInfo;
import com.zcckj.esign.dto.AuthorizedInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 查询认证授权流程详情响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetAuthFlowDetailRes implements Serializable {
    private static final long serialVersionUID = -7930386954641455507L;

    /**
     * 认证授权流程ID
     */
    private String authFlowId;

    /**
     * 认证授权主体类型
     * <p>
     * ORG - 机构实名认证，PSN - 个人实名认证
     */
    private String authType;

    /**
     * 流程中使用的认证类型
     * <p>
     * realName - 实名认证
     * <p>
     * willingness - 意愿认证
     * <p>
     * none - 都没使用
     */
    private String realNameOrWillingness;

    /**
     * 认证流程状态
     * <p>
     * 0 - 未实名，1 - 已实名
     */
    private Integer realNameStatus;

    /**
     * 授权流程状态
     * <p>
     * 0 - 流程过期失效
     * <p>
     * 1 - 已授权
     * <p>
     * 2 - 授权中
     * <p>
     * 3 - 审批未通过
     */
    private Integer authorizedStatus;

    /**
     * 认证授权长链接
     */
    private String authUrl;

    /**
     * 认证详情
     */
    private AuthInfo authInfo;


    /**
     * 本次授权详情
     */
    private AuthorizedInfo authorizedInfo;
}
