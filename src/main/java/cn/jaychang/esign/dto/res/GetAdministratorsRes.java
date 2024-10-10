package cn.jaychang.esign.dto.res;

import cn.jaychang.esign.dto.Administrator;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 查询企业管理员响应体
 */
@Data
@Accessors(chain = true)
public class GetAdministratorsRes implements Serializable {
    private static final long serialVersionUID = -215104115375050274L;

    private List<Administrator> administrators;
}
