package com.zcckj.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取文件上传状态响应体
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetFileUploadStatusRes implements Serializable {


    private static final long serialVersionUID = -8441042674573146485L;
    /**
     * 文件ID
     */
    private String fileId;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件大小（预留字段，暂时不会返回任何值，开发者可忽略）
     */
    private Integer fileSize;
    /**
     * 文件状态
     * 0 - 文件未上传
     * 1 - 文件上传中
     * 2 - 文件上传已完成 或 文件已转换（HTML）
     * 3 - 文件上传失败
     * 4 - 文件等待转换（PDF）
     * 5 - 文件已转换（PDF）
     * 6 - 加水印中
     * 7 - 加水印完毕
     * 8 - 文件转化中（PDF）
     * 9 - 文件转换失败（PDF）
     * 10 - 文件等待转换（HTML）
     * 11 - 文件转换中（HTML）
     * 12 - 文件转换失败（HTML）
     * 【注】文件添加水印功能仅e签宝SaaS高级版支持，具体功能如何接入请联系对接技术指导
     */
    private Integer fileStatus;
    /**
     * 文件下载地址（有效期为60分钟，过期后可以重新调用接口获取新的下载地址）
     */
    private String fileDownloadUrl;
    /**
     * pdf文件总页数
     */
    private Integer fileTotalPageCount;
    /**
     * 首页宽度，单位：像素（px）【注】pageSize传true才返回具体值
     */
    private Float pageWidth;
    /**
     * 首页高度，单位：像素（px）【注】pageSize传true才返回具体值
     */
    private Float pageHeight;

}
