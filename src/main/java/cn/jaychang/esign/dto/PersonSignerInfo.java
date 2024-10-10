package cn.jaychang.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 个人签署方信息
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class PersonSignerInfo implements Serializable {
    private static final long serialVersionUID = -2691155239406148242L;
    /**
     * 个人账号标识（手机号或邮箱）用于登录e签宝官网的凭证
     * <p>
     * 【注】个人用户签署时，该参数为必传项，为了保证签署人准确，必须配合psnName（个人姓名）传入
     */
    private String psnAccount;

    /**
     * 个人签署方身份信息
     * <p>
     * 补充说明：
     * <p>
     * 已实名用户，若传入的psnInfo与在e签宝绑定的psnAccount一致，则无需重复实名，签署页直接进行签署意愿认证；
     * 已实名用户，若传入的psnInfo与在e签宝绑定的psnAccount不一致，则接口将会报错，建议核实用户身份信息后重新发起流程；
     * 未实名用户，签署页将根据传入的身份信息进行用户实名认证。
     */
    private PersonIdInfo psnInfo;

}
