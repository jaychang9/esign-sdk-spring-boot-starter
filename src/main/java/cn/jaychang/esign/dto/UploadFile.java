package cn.jaychang.esign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 允许签署方在签署时上传的附件配置
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class UploadFile implements Serializable {
    private static final long serialVersionUID = 6662154025536525668L;

    /**
     * 附件的标题描述，会显示在签署详情页内
     * <p>
     * 比如：身份证信息面、身份证国徽页
     */
    private String uploadDescription;
    /**
     * 此附件是否必传，默认true
     * <p>
     * true - 必传
     * <p>
     * false - 非必传
     * <p>
     * 【注】如设置了必传，但是签署方在页面没有上传是无法提交签署的
     */
    private Boolean required;
}
