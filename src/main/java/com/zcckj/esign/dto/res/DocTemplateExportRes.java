package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 导出合同模板响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class DocTemplateExportRes implements Serializable {

    private static final long serialVersionUID = -15425576300670534L;

    /**
     * 复制结果，有效期30分钟，需要调用《导入合同模板》接口使用
     * https://open.esign.cn/doc/opendoc/pdf-sign3/cdsn3un5g0bmy64c
     */
    private String copyResult;
}
