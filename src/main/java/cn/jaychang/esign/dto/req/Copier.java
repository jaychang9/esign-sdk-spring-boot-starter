package cn.jaychang.esign.dto.req;

import cn.jaychang.esign.dto.OrgInfo;
import cn.jaychang.esign.dto.PersonInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 抄送方信息
 */
@Data
@Accessors(chain = true)
public class Copier implements Serializable {

    private static final long serialVersionUID = -3316444537881188090L;

    /**
     * 机构抄送方信息（orgName与orgId，二选一传值）
     */
    private OrgInfo copierOrgInfo;

    /**
     * 个人抄送方信息（psnAccount与psnId，二选一传值）
     */
    private PersonInfo copierPsnInfo;
}
