package cn.jaychang.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 复制合同模板请求体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class CopyDocTemplateReq implements Serializable {
    private static final long serialVersionUID = -1095158446168509141L;

    /**
     * 重命名模板名称（最长64个字）
     *
     * 【注】不传时默认取原模板名称
     */
    private String renameDocTemplate;
}
