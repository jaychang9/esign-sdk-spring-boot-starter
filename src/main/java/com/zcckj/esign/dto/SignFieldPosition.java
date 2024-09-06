package com.zcckj.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 签章区位置信息
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignFieldPosition implements Serializable {

    private static final long serialVersionUID = -7657540668813103998L;

    /**
     * 骑缝章模式选择（点击了解 骑缝盖章）
     * https://open.esign.cn/doc/opendoc/case3/yi2uzzogefr5lp1z
     * ALL - 全部页盖骑缝章，AssignedPages - 指定页码盖骑缝章
     * <p>
     * 补充说明：
     * <p>
     * 当signFieldStyle为1即单页签章时，该参数无需设置
     * 当signFieldStyle为2即骑缝签章时，可以指定该参数，默认值ALL
     */
    private String acrossPageMode;

    /**
     * 签章区所在页码
     * <p>
     * 补充说明：
     * <p>
     * （1）当signFieldStyle为1即单页签章时，只能传单个页码
     * <p>
     * （2）当signFieldStyle为2即骑缝签章时，且acrossPageMode为AssignedPages即指定页码范围时，连续页码可使用'-'指定页码范围，多个页码范围用逗号分隔，例如：1-3,6-10
     */
    private String positionPage;

    /**
     * 签章区所在X坐标（当signFieldStyle为2即骑缝签章时，该参数不生效，可不传值）
     * <p>
     * 【注】可选择如下方式可以确定坐标：
     * <p>
     * （1）开放平台拖章定位工具：【请点击】
     * https://open.esign.cn/tools/seal-position
     * （2）根据关键字辅助定位接口【请点击】
     * https://open.esign.cn/doc/opendoc/pdf-sign3/ze0ahv
     */
    private Float positionX;

    /**
     * 签章区所在Y坐标
     */
    private Float positionY;

}
