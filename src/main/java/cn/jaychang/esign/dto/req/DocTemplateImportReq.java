package cn.jaychang.esign.dto.req;

import java.io.Serializable;

/**
 * 导入合同模板请求体
 * @author zhangjie
 */
public class DocTemplateImportReq implements Serializable {


    private static final long serialVersionUID = 3358378345475203612L;

    /**
     * 复制结果，有效期30分钟，调用《导出合同模板》接口获取
     * https://open.esign.cn/doc/opendoc/pdf-sign3/eh5l0eibugqw4x4r
     */
    private String copyResult;
}
