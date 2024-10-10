package cn.jaychang.esign.dto.req;

import cn.jaychang.esign.dto.DocTemplate;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 导出合同模板请求体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class DocTemplateExportReq implements Serializable {
    private static final long serialVersionUID = 1107944890194613866L;

    /**
     * 沙箱模拟环境文件模板列表
     */
    private List<DocTemplate> docTemplateList;
}
