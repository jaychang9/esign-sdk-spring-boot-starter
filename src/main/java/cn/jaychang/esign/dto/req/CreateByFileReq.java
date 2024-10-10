package cn.jaychang.esign.dto.req;

import cn.jaychang.esign.dto.*;
import com.zcckj.esign.dto.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * （精简版）基于文件发起签署请求体
 *
 * @author zhangjie
 */
@Data
@Accessors(chain = true)
public class CreateByFileReq implements Serializable {
    private static final long serialVersionUID = -6713407505768229582L;

    /**
     * 设置待签署文件信息（点击了解 直接上传待签署文件）
     * https://open.esign.cn/doc/opendoc/case3/hxzn88wydyft769i
     * 流程中如需一次完成多份文件签署，可传入多个docs数组；
     * 当发起流程而相关签署需求无法确定时，允许不传docs（同时签署方参数signers也无需设置、是否自动开启autoStart必须设置为false），发起签署后再【追加签署文件】。
     * https://open.esign.cn/doc/opendoc/pdf-sign3/fuuzv5
     */
    private List<Doc> docs;

    /**
     * 设置附属材料信息（点击了解 添加合同附件）
     * https://open.esign.cn/doc/opendoc/case3/cz89hlq0ng7beysi
     * 【注】附属材料即附件，指无需签名的文件，仅用于查看
     */
    private List<Attachment> attachments;


    /**
     * 签署流程配置项
     */
    private SignFlowConfig signFlowConfig;


    /**
     * 签署流程的发起方（指在平台中发起合同签约的一方，合同的归属方，有权限查看签署的文件，签署通知中展示：“XXX 通知您签署... ”中的XXX即为发起方名字。）
     * <p>
     * （点击了解 指定合同发起方）
     * https://open.esign.cn/doc/opendoc/case3/bgs7lwkpz0fezgup
     * 不传则默认为应用ID所属的企业来发起签署流程；
     * 发起方可以为个人或者机构，但不可同时传值
     * （orgInitiator与psnInitiator 二选一传入）；
     * <p>
     * 当指定发起方为非应用ID所属企业时，需先经过【用户授权】
     * https://open.esign.cn/doc/opendoc/auth3/lmfokx
     * （代个人/企业用户发起合同签署权限）。
     */
    private SignFlowInitiator signFlowInitiator;

    /**
     * 签署方信息（指参与签署的个人或者机构）
     * <p>
     * （点击了解 如何指定双方签署）
     * https://open.esign.cn/doc/opendoc/case3/evesulzd0efhg59y
     * 单个签署方数组中，机构签署方、个人签署方二选一传入
     * （orgSignerInfo与psnSignerInfo二选一即可）；
     * <p>
     * 多方签署场景，可传多个签署方数组；
     * 单个签署流程中，签署方最多不能超过10个。
     * 【注】该接口如果未添加签署方信息，则需要后续在流程中添加，调用【追加签署区】接口添加。
     * https://open.esign.cn/doc/opendoc/pdf-sign3/ohzup7
     */
    private List<Signer> signers;

    /**
     * 抄送方信息（指不参与签署的机构或者个人，流程结束后将收到通知，允许查看签署文件）
     * <p>
     * （点击了解 添加合同抄送方）
     * https://open.esign.cn/doc/opendoc/case3/uiviglpo2yg7rhd0
     * <p>
     * 如需抄送多个企业或个人，允许传入多个抄送方数组；
     * 抄送机构的情况：copierOrgInfo与copierPsnInfo均需传值；抄送个人的情况：仅需传copierPsnInfo；
     */
    private List<Copier> copiers;
}
