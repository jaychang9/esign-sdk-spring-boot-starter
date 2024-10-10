package cn.jaychang.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 个人信息
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class PersonInfo implements Serializable {

    private static final long serialVersionUID = 534793228343551792L;

    /**
     * 个人账号标识（手机号/邮箱号）
     */
    private String psnAccount;

    /**
     * 个人账号ID
     */
    private String psnId;

}