package cn.jaychang.esign.dto.res;

import cn.jaychang.esign.dto.AuthorizedInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 查询机构授权信息响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetOrgAuthorizedInfoRes implements Serializable {
    private static final long serialVersionUID = 5517573994835963261L;

    private List<AuthorizedInfo> authorizedInfo;
}
