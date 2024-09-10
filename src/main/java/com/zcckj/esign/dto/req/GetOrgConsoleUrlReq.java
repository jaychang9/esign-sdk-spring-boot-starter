package com.zcckj.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 获取免登录企业控制台页面请求体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetOrgConsoleUrlReq implements Serializable {
    private static final long serialVersionUID = -7810649143268975669L;

    /**
     * 机构账号ID
     */
    private String orgId;

    /**
     * 经办人账号ID
     */
    private String transactorPsnId;

    /**
     * 页面是否展示顶部栏
     * <p>
     * true - 展示（默认值）
     * <p>
     * false - 隐藏
     */
    private Boolean showTopBar;

    /**
     * 指定页面中展示的菜单（默认按照成员角色权限展示）
     * <p>
     * org_info（企业信息页面）
     * org_seal_manage （企业印章管理页面）
     * org_member_manage（企业成员管理页面）
     * org_place_order （企业下单页面）
     * org_order_manage （企业订单管理页面）
     */
    private List<String> menu;

    /**
     * 页面配置项
     */
    private PageConfig pageConfig;


    /**
     * 页面配置项
     */
    @Data
    @Accessors(chain = true)
    public static class PageConfig implements Serializable {

        private static final long serialVersionUID = 7753447533711294720L;
        /**
         * 是否仅查询渠道商维度的订单（企业订单管理页面），
         * <p>
         * true - 是
         * <p>
         * false - 否（默认值）
         */
        private Boolean distributor;
    }

}
