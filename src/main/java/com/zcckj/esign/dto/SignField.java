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

    /**
     * 签署区类型，默认值为 0
     *
     * 0 - 签章区 （添加印章、签名等）
     *
     * 1 - 备注区（添加备注文字信息等）（点击了解 备注签署）
     *
     * 2 - 独立签署日期（添加单独的签署日期）
     */
    private Integer signFieldType;

    /**
     * 该签署区是否必须签署，默认值为 true（必须签）
     *
     * true - 是
     *
     * false - 否
     *
     * 场景对接说明详见：【选签（非必须签）】（该参数设置：false时）
     *
     * 补充说明：
     *
     * 常规场景都是必须签署，不需要额外指定该参数为 false，如果需要选签（非必须签）功能，则不允许设置自动落章。
     */
    private Boolean mustSign;

    /**
     * 签章区配置项（指定signFieldType为 0 - 签章区时，该参数为必传项）
     */
    private NormalSignFieldConfig normalSignFieldConfig;

    /**
     * 备注区配置项（指定signFieldType为 1 - 备注区时，该参数为必传项）
     *
     * （点击了解 备注签署）
     *  https://open.esign.cn/doc/opendoc/case3/pxlkdri00a37c2zy
     * 【注】备注区只支持个人签署方
     */
    private RemarkSignFieldConfig remarkSignFieldConfig;

    /**
     * 签署区/备注区的签署日期配置项
     *
     * （点击了解 添加签署日期）
     *  https://open.esign.cn/doc/opendoc/case3/yg6tb63yvnbdl7x3
     * 补充说明：
     *
     * 该日期是跟签署区/备注区关联的，即一个签署区/备注区需要一个签署日期匹配，且必须和签署区/备注区在同一页码
     * 当signFieldType（签署区类型）= 0（签章区）时，指定该参数
     */
    private SignDateConfig signDateConfig;

    /**
     * 独立签署日期配置项
     *
     * 补充说明：
     *
     * 该日期是跟签署区/备注区独立的，只要保证一个用户下存在至少一个签署区/备注区即可，可以配置多个日期位置且支持和签署区/备注区不在同一页码
     * 当signFieldType（签署区类型）= 2（独立签署日期）时，指定该参数
     */
    private DateSignFieldConfig dateSignFieldConfig;
}
