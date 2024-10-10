package cn.jaychang.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * （精简版）基于文件发起签署响应体
 *  @author zhangjie
 */
@Data
@Accessors(chain = true)
public class CreateByFileRes implements Serializable {
    private static final long serialVersionUID = -5089919993632516941L;
    /**
     * 签署流程ID（建议开发者保存此流程ID）
     */
    private String signFlowId;
}
