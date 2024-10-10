package cn.jaychang.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 复制合同模板响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class CopyDocTemplateRes implements Serializable {
    private static final long serialVersionUID = 2253185849957731031L;

    /**
     * 新合同模板ID
     */
    private String newDocTemplateId;

    /**
     * 控件列表
     */
    private List<Component> componentList;


    /**
     * 控件
     */
    @Data
    @Accessors(chain = true)
    public static class Component implements Serializable {

        private static final long serialVersionUID = 7179651929669643912L;

        /**
         * 原始控件ID
         */
        private String originComponentId;

        /**
         * 新控件ID
         */
        private String newComponentId;
    }

}
