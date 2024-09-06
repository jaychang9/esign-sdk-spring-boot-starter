package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 签署人签署配置项
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignConfig implements Serializable {
    private static final long serialVersionUID = -3092883406164758291L;
    /**
     * 设置页面强制阅读倒计时时间，默认值为 0（单位：秒，最大值999）
     */
    private Integer forcedReadingTime;
    /**
     * 设置签署方的签署顺序
     *
     * 按序签时支持传入顺序值 1 - 255（值小的先签署）
     * 同时签时，允许值重复
     */
    private Integer signOrder;

    /**
     * 签署人是否需要免意愿快捷签署，默认false
     *
     * true - 需要
     *
     * false - 不需要
     *
     * （点击了解 免意愿快捷签署）
     * https://open.esign.cn/doc/opendoc/case3/ci573w8my7u1sok7
     *
     * 补充说明：
     *
     * 免意愿快捷签署需要提前联系与您对接的技术/业务人员确认场景，场景审批通过后开通才可使用（例如：处方单、物流承运协议等需要个人频繁签署的低风险场景，企业签署不支持，仅限个人签署）；
     * 免意愿快捷签署是指用户在e签宝页面签署过程中勾选同意《快捷签署服务协议》后，当前用户在约定时间内（默认7天）再次在当前开发者appId、当前终端设备下签署即可免除意愿认证，直接签署成功。
     */
    private Boolean agreeSkipWillingness;

    /**
     * 签署任务类型，默认值为 0
     *
     * 0 - 会签（所有指定的签署方均必须签署）
     *
     * 1 - 或签（多个签署方中，任意一方签署即可完成签署流程）
     *
     * （点击了解 会签与或签）
     * https://open.esign.cn/doc/opendoc/case3/lb39ii9p1133hh0u
     * 或签场景补充说明：
     *
     * 指定的签署方数量必须>=2，其中任意一方签署即可
     * 所有签署方和签署区的配置以及签署的文件需要一致
     * 或签不允许自动签署
     * 不允许同一个经办人代不同的主体或签
     */
    private Integer signTaskType;


    /**
     * 签署前提示弹框自定义签署声明--文案标题（最多20字）
     *
     * 补充说明：
     *
     * 当前签署方在签署页面进入后，展示该弹框提示，点击“我已知悉上述内容”按钮后关闭弹框，进入签署合同页。
     * 必须与下方signTipsContent字段配套使用。
     */
    private String signTipsTitle;

    /**
     * 签署前提示弹框自定义签署声明--文案内容（最多500字）
     *
     * 补充说明：
     *
     * 当前签署方在签署页面进入后，展示该弹框提示，点击“我已知悉上述内容”按钮后关闭弹框，进入签署合同页。
     * 必须与上方signTipsTitle字段配套使用。
     */
    private String signTipsContent;

    /**
     * 允许签署方在签署时上传的附件列表配置
     *
     * 补充说明：
     *
     * 需要签署方在签署页自主上传附属材料时，对应的附属文件要求在此配置
     * 不需要签署方自主上传附件时，此项无需传入
     */
    private List<UploadFile> uploadFiles;


    /**
     * 签署方可见文件类型，默认：1
     *
     * 1：允许查看流程内所有文件
     *
     * 2：仅允许查看自身签署的文件和指定文件（通过viewableFileIds指定文件id列表）
     *
     * 【注】：流程配置里的docsViewLimited需要传：true，这里指定2才生效。
     */
    private Integer docsViewType;


    /**
     * 指定签署方允许查看的文件id列表（仅在docsViewType为2的情况下生效）
     */
    private List<String> viewableFileIds;

}