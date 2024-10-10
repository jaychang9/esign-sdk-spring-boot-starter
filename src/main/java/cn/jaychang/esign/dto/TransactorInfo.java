package cn.jaychang.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 企业/机构经办人信息
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class TransactorInfo implements Serializable {

    private static final long serialVersionUID = -396088728733315657L;

    /**
     * 经办人账号标识，手机号或邮箱
     * <p>
     * 【注】指定orgName时，该参数为必传项，为了保证签署人准确，必须配合psnName（经办人姓名）传入
     */
    private String psnAccount;

    /**
     * 经办人账号ID（指定orgId时，该参数为必传项）
     * <p>
     * 【注】用户在e签宝注册实名后才有账号ID，账号ID获取方式请使用【查询个人认证信息】接口通过个人账号标识（手机号或邮箱）/个人用户的证件号进行查询
     * https://open.esign.cn/doc/opendoc/auth3/vssvtu
     */
    private String psnId;

    /**
     * 经办人身份信息
     */
    private PersonIdInfo psnInfo;
}
