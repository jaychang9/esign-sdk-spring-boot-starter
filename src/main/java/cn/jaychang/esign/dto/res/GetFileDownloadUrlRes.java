package cn.jaychang.esign.dto.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 查询PDF模板填写后文件响应体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class GetFileDownloadUrlRes implements Serializable {
    private static final long serialVersionUID = -7301864825554478075L;

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
     * 文件状态（填写PDF模板后生成的文件状态只可能是2）
     * <p>
     * 0 - 文件未上传
     * <p>
     * 1 - 文件上传中
     * <p>
     * 2 - 文件上传已完成 或 文件已转换（HTML）
     * <p>
     * 3 - 文件上传失败
     * <p>
     * 4 - 文件等待转换（PDF）
     * <p>
     * 5 - 文件已转换（PDF）
     * <p>
     * 6 - 加水印中
     * <p>
     * 7 - 加水印完毕
     * <p>
     * 8 - 文件转化中（PDF）
     * <p>
     * 9 - 文件转换失败（PDF）
     * <p>
     * 10 - 文件等待转换（HTML）
     * <p>
     * 11 - 文件转换中（HTML）
     * <p>
     * 12 - 文件转换失败（HTML）
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
     * 首页宽度，单位：像素（px）
     * <p>
     * 【注】pageSize传true才返回具体值
     */
    private Float pageWidth;

    /**
     * 首页高度，单位：像素（px）
     * <p>
     * 【注】pageSize传true才返回具体值
     */
    private Float pageHeight;
}
