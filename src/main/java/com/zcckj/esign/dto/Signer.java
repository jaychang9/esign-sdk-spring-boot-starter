package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 签署方信息（指参与签署的个人或者机构）
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

}
