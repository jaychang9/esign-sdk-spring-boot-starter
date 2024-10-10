package cn.jaychang.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取制作合同模板页面请求体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetDocTemplateEditUrlReq implements Serializable {

    private static final long serialVersionUID = -6430075568843270582L;

    /**
     * 编辑模板完成后页面重定向跳转地址（需符合 https /http 协议地址）
     */
    private String redirectUrl;
}
