package com.zcckj.esign.dto.req;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 延长签署截止时间请求体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class SignFlowDelayReq implements Serializable {
    private static final long serialVersionUID = -5036609655054960870L;

    /**
     * 新的签署截止时间（unix时间戳格式，单位：毫秒）
     */
    private Long signFlowExpireTime;
}
