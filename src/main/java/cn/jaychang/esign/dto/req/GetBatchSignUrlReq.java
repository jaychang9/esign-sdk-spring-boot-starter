package cn.jaychang.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;
import retrofit2.http.Body;

import java.io.Serializable;
import java.util.List;

/**
 * 获取批量签页面链接（多流程）请求体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetBatchSignUrlReq implements Serializable {
    private static final long serialVersionUID = 3854972022779027606L;

    /**
     * 签署人账号ID（请传入个人账号ID或企业经办人账号ID）
     */
    private String operatorId;

    /**
     * 待签署流程ID列表（默认最多支持10个流程）
     *
     * 通过【查询签署流程列表】接口获取到的signFlowId；
     * 仅支持传入状态为“签署中”的流程ID。
     */
    private List<String> signFlowIds;

    /**
     * 是否强制阅读，默认false
     *
     * true-强制阅读所有文件后才能签署
     *
     * false-不强制阅读
     */
    private Boolean forcedRead;

    /**
     * 指定客户端类型，默认ALL
     *
     * ALL - 自动适配移动端或PC端
     *
     * H5 - 移动端适配
     *
     * PC - PC端适配
     */
    private String clientType;

    /**
     * 重定向地址，签署完成结果页确认后跳转地址
     *
     * 【注】贵司的重定向域名需要在e签宝提前放行，否则会报错：“您即将访问的页面可能有安全风险”。（点击跳转 重定向域名配置说明）
     *  https://open.esign.cn/doc/opendoc/dev-guide3/umo8rop7dmttkdnv
     */
    private String redirectUrl;

    /**
     * AppScheme，主要用于支付宝人脸认证重定向时跳回开发者自身App。
     *
     * 示例值：esign://demo/signBack
     *
     * （点击了解 APP内嵌签署/认证H5对接说明）
     *  https://open.esign.cn/doc/opendoc/case3/ovb0e40do4fnrr61
     */
    private String appScheme;
}
