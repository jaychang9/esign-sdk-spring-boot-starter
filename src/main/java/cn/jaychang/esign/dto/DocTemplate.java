package cn.jaychang.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 文件模板
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class DocTemplate implements Serializable {
    /**
     * 自定义业务编码
     */
    private String customBizNum;
    /**
     * 要复制的合同模板ID（必须是当前appId下创建的）
     */
    private String docTemplateId;
}
