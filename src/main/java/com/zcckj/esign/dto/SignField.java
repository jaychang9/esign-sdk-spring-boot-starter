package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 签署区信息
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignField implements Serializable {
    /**
     * 签署区所在待签署文件ID
     *
     * 【注】这里的fileId需先添加在docs数组中，否则会报错“参数错误: 文件id不在签署流程中”
     */
    private String fileId;

    /**
     * 开发者自定义业务编号
     *
     * 【注】该参数会在【签署方-签署结果通知】中原样返回，用于标识开发者自身业务
     *  https://open.esign.cn/doc/opendoc/notify3/zzcdf8
     */
    private String customBizNum;

}
