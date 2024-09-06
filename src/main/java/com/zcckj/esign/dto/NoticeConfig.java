package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 设置签署方的通知方式
 */
@Data
@Accessors(chain = true)
public class NoticeConfig implements Serializable {
    private static final long serialVersionUID = 591494505371825545L;
    /**
     * 通知类型，默认不通知（值为""空字符串），允许多种通知方式，请使用英文逗号分隔
     *
     * （点解了解 指定e签宝短信/邮件通知签署）
     *  https://open.esign.cn/doc/opendoc/case3/uk2lbd9ictbycpz1
     * 传空 - 不通知（默认值）
     *
     * 1 - 短信通知（如果套餐内带“分项”字样，请确保开通【电子签名流量费（分项）认证】中的子项：【短信服务】，否则短信通知收不到）
     *
     * 2 - 邮件通知
     *
     * 补充说明：
     *
     * 个人账号中需要绑定短信/邮件才有对应的通知方式。
     * 该通知是签署方维度的，只控制签署人的签署提醒短信，不控制流程的撤销、完成、抄送等短信通知
     */
    private String noticeTypes;
}
