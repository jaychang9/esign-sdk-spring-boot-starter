package cn.jaychang.esign.dto.res;

import cn.jaychang.esign.dto.DocTemplate;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 导入合同模板响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class DocTemplateImportRes implements Serializable {


    private static final long serialVersionUID = 4592099687869294108L;
    /**
     * 复制后的生产环境文件模板ID列表
     */
    private List<DocTemplate> docTemplateList;
}
