package cn.jaychang.esign.dto.res;

import cn.jaychang.esign.dto.AuthorizedInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 查询个人授权信息响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetPersonAuthorizedInfoRes implements Serializable {

    private static final long serialVersionUID = 8885122671532991282L;

    /**
     * 用户授权信息列表
     */
    private List<AuthorizedInfo> authorizedInfo;
}
