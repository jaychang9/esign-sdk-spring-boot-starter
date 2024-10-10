package cn.jaychang.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 合同相关配置项
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class ContractConfig implements Serializable {
    /**
     * 合同保密配置，默认：1 - 合同不保密
     * <p>
     * 1 - 合同不保密
     * <p>
     * 2 - 合同全部保密
     * <p>
     * （合同保密功能同e签宝SaaS官网一致，点击了解）
     * https://help.esign.cn/detail?id=yd2cqo&nameSpace=cs3-dept%2Fexboae
     */
    private Integer contractSecrecy;

    /**
     * 该签署流程是否允许发起解约，默认true
     * <p>
     * true - 允许
     * <p>
     * false - 不允许
     */
    private Boolean allowToRescind;
}
