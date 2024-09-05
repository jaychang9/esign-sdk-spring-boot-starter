package com.zcckj.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 填写模板生成文件请求体
 */
@Data
@Accessors(chain = true)
public class CreateByDocTemplateReq implements Serializable {
    private static final long serialVersionUID = 4779331401673625036L;

    /**
     * 待填充的模板ID（通过【获取制作合同模板页面https://open.esign.cn/doc/opendoc/pdf-sign3/xagpot】接口获取）
     */
    private String docTemplateId;

    /**
     * 填充后生成的文件名称（可自定义文件名称）
     * <p>
     * 【注】文件名称不可含有以下9个特殊字符：/ \ : * " < > | ？以及所有emoji表情
     */
    private String fileName;

    /**
     * 控件列表（控件ID和 控件Key 二选一传值）
     */
    private List<CreateByDocTemplateComponent> components;
    
    /**
     * 是否校验PDF模板中必填控件，默认：false
     * <p>
     * false：不校验模板中必填控件（components必须传，可以传空数组）；
     * <p>
     * true：校验模板中必填控件 ，必填控件不传值会报错："创建合同失败: 'XX控件名称'填充内容缺失" 。
     * <p>
     * 补充说明：
     * <p>
     * 该参数只针对PDF模板生效，HTML模板不生效，即：HTML模板会强制校验必填控件。
     */
    private Boolean requiredCheck;


    /**
     * 控件列表（控件ID和 控件Key 二选一传值）
     */
    @Data
    @Accessors(chain = true)
    public static class CreateByDocTemplateComponent implements Serializable {
        /**
         * 控件ID（设置合同模板时由e签宝系统自动生成）
         */
        private String componentId;

        /**
         * 控件Key（设置合同模板时由用户自定义）
         */
        private String componentKey;

        /**
         * 控件填充值
         * <p>
         * 补充说明：
         * <p>
         * （1）可根据控件类型进行填充，点击查看填充值示例；
         * <p>
         * （2）填充动态表格控件时，若需新增一行数据时 insertRow 参数值必须传 true；
         * <p>
         * （3）点击查看如何填充动态表格。
         */
        private String componentValue;
    }
}
