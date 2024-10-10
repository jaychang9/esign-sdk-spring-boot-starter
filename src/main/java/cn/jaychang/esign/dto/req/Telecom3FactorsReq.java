package cn.jaychang.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 运营商三要素核验请求体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class Telecom3FactorsReq implements Serializable {

    private static final long serialVersionUID = 14691601836409289L;
    /**
     * 身份证号
     */
    private String idNo;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String mobileNo;
}
