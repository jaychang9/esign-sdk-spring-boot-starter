package com.zcckj.esign.dto.req;

import com.zcckj.esign.dto.RedirectConfig;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取签署页面链接请求体
 *
 * @author zhangjie
 */
public class GetSignUrlReq implements Serializable {

    private static final long serialVersionUID = 2056873854764630374L;

    /**
     * 签署流程ID
     */
    private String signFlowId;

    /**
     * 是否需要登录打开链接（默认值 false）
     * <p>
     * true - 需登录打开链接，false - 免登录
     */
    private Boolean needLogin;

    /**
     * 链接类型（默认值 2）
     * <p>
     * 1 - 预览链接（仅限查看，不能签署）， 2 - 签署链接
     */
    private Integer urlType;

    /**
     * 个人签署方（机构签署传经办人信息）
     * <p>
     * 当获取签署链接场景，需传入当前流程流转到的签署操作人信息。
     * psnAccount与psnId二选一传入（必须与发起签署时的账号保持一致）
     * 【注】大多数场景必传字段，如不传该参数，后台默认自动带入appId对应主体信息，获取平台方预览合同地址
     */
    private Operator operator;

    /**
     * 机构签署方
     * <p>
     * 一个流程中存在经办人代多个机构签署时，通过此参数分别获取对应机构的签署链接；
     * orgId与orgName二选一传入（必须与发起签署时账号保持一致）
     */
    private Organization organization;


    /**
     * 重定向配置项
     */
    private RedirectConfig redirectConfig;


    /**
     * 指定客户端类型，当urlType为2（签署链接）时生效
     * <p>
     * H5 - 移动端适配
     * <p>
     * PC - PC端适配
     * <p>
     * ALL - 自动适配移动端或PC端（默认值）
     * <p>
     * 【注】参数值均为大写的英文
     */
    private String clientType;

    /**
     * AppScheme，主要用于支付宝人脸认证重定向时跳回开发者自身App。
     * <p>
     * 示例值：esign://demo/signBack
     * <p>
     * （点击了解 APP内嵌签署/认证H5对接说明）
     *  https://open.esign.cn/doc/opendoc/case3/ovb0e40do4fnrr61
     */
    private String appScheme;


    /**
     * 个人签署方
     *
     * @author zhangjie
     */
    @Data
    @Accessors(chain = true)
    public static class Operator implements Serializable {
        /**
         * 签署操作人账号标识（手机号/邮箱号）
         */
        private String psnAccount;

        /**
         * 签署操作人账号ID（个人账号ID）
         */
        private String psnId;
    }

    /**
     * 机构签署方
     */
    @Data
    @Accessors(chain = true)
    public static class Organization implements Serializable {
        /**
         * 机构账号ID
         */
        private String orgId;

        /**
         * 机构名称
         */
        private String orgName;
    }

}
