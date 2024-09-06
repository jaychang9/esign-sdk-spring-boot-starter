package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 签署方信息（指参与签署的个人或者机构）
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class Signer implements Serializable {
    private static final long serialVersionUID = -1439308266284804179L;

    /**
     * 签署人配置项
     */
    private SignConfig signConfig;

    /**
     * 签署方维度认证配置项
     */
    private SignerAuthConfig authConfig;

    /**
     * 设置签署方的通知方式
     */
    private NoticeConfig noticeConfig;


    /**
     * 签署方类型
     * <p>
     * 0 - 个人，1 -企业/机构，2 - 法定代表人，3 - 经办人
     * <p>
     * 若指定签署方为个人，则psnSignerInfo为必传项；
     * 若指定签署方为机构或法定代表人手动签署（autoSign参数为false）时，则orgSignerInfo为必传项；
     * 若指定签署方为经办人，在同级数组内必须还有机构类型存在，且orgSignerInfo为必传项，即：指定3 - 经办人签的前提是必须同时存在1 - 企业/机构，且经办人签属于企业合同，不在个人名下。
     */
    private Integer signerType;

    /**
     * 企业/机构签署方信息
     * <p>
     * 当签署主体为企业/机构用户、autoSign参数为false手动签章时，请必须传入此对象（orgName与orgId二选一传值即可）
     * 当企业/机构用户选择静默签署，autoSign参数为true自动落章时，建议不传此对象，e签宝后台会取默认值
     */
    private OrgSignerInfo orgSignerInfo;

    /**
     * 个人签署方信息
     * <p>
     * 当签署主体为个人时请传此对象，psnAccount与psnId二选一传值即可
     */
    private PersonSignerInfo psnSignerInfo;

    /**
     * 签署区信息（设置签署方 盖章/签名/文字输入的区域）
     * <p>
     * 【注】指定了签署方signers的情况下，签署区必传
     * <p>
     * （单个签署方若对应多个签署区，可传多个数组，整个流程中，签署区不能超过300个）
     */
    private List<SignField> signFields;

}
