package cn.jaychang.esign.constant;

/**
 * 请求e签宝接口请求头名称，值常量
 */
public class ESignConstant {
    // 调用e签宝请求头需要用到的 header key 名称
    public static final String ACCEPT_HEADER_NAME = "Accept";
    public static final String CONTENT_TYPE_HEADER_NAME = "Content-Type";
    public static final String CONTENT_MD5_HEADER_NAME = "Content-MD5";

    public static final String APP_ID_HEADER_NAME = "X-Tsign-Open-App-Id";
    public static final String AUTH_MODE_HEADER_NAME = "X-Tsign-Open-Auth-Mode";
    public static final String SIGNATURE_HEADER_NAME = "X-Tsign-Open-Ca-Signature";
    public static final String TIMESTAMP_HEADER_NAME = "X-Tsign-Open-Ca-Timestamp";


    public static final String DEFAULT_CONTENT_TYPE_HEADER_VALUE = "application/json; charset=UTF-8";
    public static final String DEFAULT_ACCEPT_HEADER_VALUE = "*/*";
    public static final String DEFAULT_AUTH_MODE_HEADER_VALUE = "Signature";

    // 通知的业务类型 key 名
    public static final String CALLBACK_ACTION_KEY = "action";


    // 通知的业务类型
    // 文件类
    /**
     * 文件模板创建或编辑完成通知
     */
    public static final String EDIT_DOCTEMPLATE_ACTION = "EDIT_DOCTEMPLATE";

    /**
     * 文件模板填写完成通知
     */
    public static final String FILL_DOCTEMPLATE_ACTION = "FILL_DOCTEMPLATE";

    /**
     * 文件模板填写失败通知
     */
    public static final String FILL_DOCTEMPLATE_FAIL_ACTION = "FILL_DOCTEMPLATE_FAIL";

    // 认证授权类
    /** 实名认证通过通知*/
    public static final String AUTH_PASS_ACTION = "AUTH_PASS";
    /**
     * 授权完成通知
     */
    public static final String AUTHORIZE_FINISH_ACTION = "AUTHORIZE_FINISH";

    // 签署类
    /**
     * 签署发起成功通知
     */
    public static final String SIGN_FLOW_INITIATED_ACTION = "SIGN_FLOW_INITIATED";


    /**
     * 签署方-签署结果通知
     */
    public static final String SIGN_MISSION_COMPLETE_ACTION = "SIGN_MISSON_COMPLETE";

    /**
     * 签署人更正个人信息回调通知
     */
    public static final String OPERATOR_CORRECT_IDENTITY_ACTION = "OPERATOR_CORRECT_IDENTITY";

    /**
     * 签署方-已读通知
     */
    public static final String OPERATOR_READ_ACTION = "OPERATOR_READ";

    /**
     * 流程结束通知
     */
    public static final String SIGN_FLOW_COMPLETE_ACTION = "SIGN_FLOW_COMPLETE";


    // 企业控制台回调通知
    /**
     * 企业信息变更（企业名字修改）变更通知
     */
    public static final String UPDATE_ORG_NAME_ACTION = "UPDATE_ORG_NAME";

    /**
     * 法定代表人信息变更通知
     */
    public static final String UPDATE_LEGAL_REP_ACTION = "UPDATE_LEGAL_REP";


    /**
     * 管理员转授成功通知
     */
    public static final String DELEGATE_ADMIN_ACTION = "DELEGATE_ADMIN";

}
