package cn.jaychang.esign.dto.cb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 机构认证信息（机构认证场景返回此参数）
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class Organization implements Serializable {


    private static final long serialVersionUID = -4029327387509109616L;
    /**
     * 机构账号ID
     */
    private String orgId;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 经办人认证信息
     */
    private PsnInfo transactor;
}