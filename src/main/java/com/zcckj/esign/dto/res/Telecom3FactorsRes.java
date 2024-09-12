package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 运营商三要素核验响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class Telecom3FactorsRes implements Serializable {

    private static final long serialVersionUID = 902432567006498108L;

    /**
     * 核验ID
     */
    private String verifyId;
}
