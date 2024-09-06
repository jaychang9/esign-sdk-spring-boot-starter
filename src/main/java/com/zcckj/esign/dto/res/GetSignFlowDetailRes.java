package com.zcckj.esign.dto.res;

import com.zcckj.esign.dto.SignFlowInitiator;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 查询签署流程详情响应体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetSignFlowDetailRes implements Serializable {
    private static final long serialVersionUID = -5176871837315508453L;

    /**
     * 当前流程的状态
     *
     * 0 - 草稿
     *
     * 1 - 签署中
     *
     * 2 - 完成
     *
     * 3 - 撤销
     *
     * 5 - 过期（签署截至日期到期后触发）
     *
     * 7 - 拒签
     *
     * 点击这里了解更多流程状态说明。
     * https://open.esign.cn/doc/opendoc/pdf-sign3/gsy6xe
     */
    private Integer signFlowStatus;

    /**
     * 签署流程描述
     *
     * 如果流程已拒签或已撤销，并且存在拒签或撤回原因，流程描述显示为原因,，否则默认为流程状态描述
     */
    private String signFlowDescription;

    /**
     * 签署流程的解约状态
     *
     * 0 - 未解约
     *
     * 1 - 解约中
     *
     * 2 - 部分解约
     *
     * 3 - 已解约
     */
    private Integer rescissionStatus;

    /**
     * 对应的解约协议签署流程ID
     */
    private List<String> rescissionSignFlowIds;

    /**
     * 签署流程创建时间（毫秒级时间戳格式）
     */
    private Long signFlowCreateTime;

    /**
     * 签署流程开启时间（毫秒级时间戳格式）
     */
    private Long signFlowStartTime;

    /**
     * 签署流程结束时间（毫秒级时间戳格式）
     */
    private Long signFlowFinishTime;

    private SignFlowInitiator signFlowInitiator;


}
