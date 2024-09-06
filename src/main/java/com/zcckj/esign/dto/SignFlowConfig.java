package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class SignFlowConfig implements Serializable {
    private static final long serialVersionUID = 2790118616708716229L;
    /**
     * 签署流程主题（将展示在签署通知和签署页的任务信息中）
     *
     * 【注】主题名称不可含有以下9个特殊字符：/ \ : * " < > | ？以及所有emoji表情
     */
    private String signFlowTitle;
    /**
     * 签署截止时间， unix时间戳（毫秒）格式（点击了解 指定签署截止日期）
     * https://open.esign.cn/doc/opendoc/case3/rhb8htbiaq8hl3td
     * 补充说明：
     *
     * 默认在签署流程创建后的90天时截止（指定值最大不能超过90天，只能指定90天内的时间戳）。签署中如需延期请调用【延期签署截止时间】接口。
     * https://open.esign.cn/doc/opendoc/pdf-sign3/idv0fv
     */
    private Integer signFlowExpireTime;
    /**
     * 所有签署方签署完成后流程自动完结，默认值 false
     *
     * true - 自动完结
     *
     * false - 非自动完结，需调用【完结签署流程】接口完结
     * https://open.esign.cn/doc/opendoc/pdf-sign3/ynwqsm
     *
     * 补充说明：
     *
     * 设置了自动完结的流程中不允许再追加签署区、抄送方，点击这里了解更多流程状态说明。
     * https://open.esign.cn/doc/opendoc/pdf-sign3/gsy6xe
     *
     */
    private Boolean autoFinish;
    /**
     * 接收相关回调通知的Web地址，详见【签署回调通知接收说明】。
     * https://open.esign.cn/doc/opendoc/notify3/sblzg8
     */
    private String notifyUrl;

    @Data
    @Accessors(chain = true)
    public static class RedirectConfig implements Serializable {
        /**
         * 签署完成后跳转页面（除app和小程序端集成外，地址需符合 https /http 协议地址）
         *
         * 【注】贵司的重定向域名需要在e签宝提前放行，否则会报错：“您即将访问的页面可能有安全风险”。（点击跳转 重定向域名配置说明）
         *  https://open.esign.cn/doc/opendoc/dev-guide3/umo8rop7dmttkdnv
         */
        private String redirectUrl;
    }
}