package cn.jaychang.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 经办人身份信息
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class PersonIdInfo implements Serializable {
    private static final long serialVersionUID = 8825323350498934515L;
    /**
     * 经办人姓名
     * <p>
     * 【注】传psnAccount（经办人账号标识）时，该参数为必传项
     */
    private String psnName;

    /**
     * 经办人证件号
     */
    private String psnIDCardNum;

    /**
     * 经办人证件类型，可选值如下：
     * <p>
     * CRED_PSN_CH_IDCARD - 中国大陆居民身份证（默认值）
     * <p>
     * CRED_PSN_CH_HONGKONG - 香港来往大陆通行证（回乡证）
     * <p>
     * CRED_PSN_CH_MACAO - 澳门来往大陆通行证（回乡证）
     * <p>
     * CRED_PSN_CH_TWCARD - 台湾来往大陆通行证（台胞证）
     * <p>
     * CRED_PSN_PASSPORT - 护照
     */
    private String psnIDCardType;
}