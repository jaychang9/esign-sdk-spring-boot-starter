package com.zcckj.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 催签流程中签署人请求体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignFlowUrgeReq implements Serializable {
    private static final long serialVersionUID = -5256503198169425566L;

    /**
     * 通知方式（多种方式使用英文逗号分隔）
     * <p>
     * 1- 短信，2 - 邮件 ，默认按照流程设置
     * <p>
     * （如果套餐内带“分项”字样，请确保开通【电子签名流量费（分项）认证】中的子项：【短信服务】，否则短信通知收不到
     */
    private String noticeTypes;

    /**
     * 指定被催签的签署人
     * <p>
     * 为空表示：催签当前轮到签署但还未签署的所有签署人
     * 按被催签人的账号标识或账号ID方式（二选一，根据发起签署时传入方式决定）
     */
    private UrgedOperator urgedOperator;

    /**
     * 指定被催签的签署人
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class UrgedOperator implements Serializable {

        private static final long serialVersionUID = 8692875046373473224L;

        /**
         * 被催签人账号标识（手机号/邮箱）
         * <p>
         * （与psnId二选一传入，根据发起签署时传入方式决定）
         */
        private String psnAccount;

        /**
         * 被催签人账号ID
         * <p>
         * （与psnAccount二选一传入，根据发起签署时传入方式决定）
         */
        private String psnId;
    }
}
