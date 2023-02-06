package com.leeup.shortlink.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author clee
 * @description 统一响应码定义
 * @date 4/9/2022 下午3:08
 **/
@AllArgsConstructor
@Getter
public enum ResponseCode {

    /**
     * 短链分组
     */
    GROUP_REPEAT("group_repeat","分组名重复"),

    GROUP_NAME_OPERATION_FAIL("group_name_operation_fail","分组名操作失败"),

    GROUP_NOT_EXIST("group_not_exist","分组不存在"),

    /**
     * 验证码
     */
    CODE_TO_ERROR("code_to_error","接收号码不合规"),

    CODE_LIMITED("code_limited","验证码发送过快"),

    CODE_ERROR("code_error","验证码错误"),

    CODE_CAPTCHA_ERROR("code_captcha_error","图形验证码错误"),

    /**
     * 账号
     */
    ACCOUNT_REPEAT("account_repeat","账号已经存在"),

    ACCOUNT_UNREGISTER("account_unregister","账号不存在"),

    ACCOUNT_PWD_ERROR("account_pwd_error","账号或者密码错误"),

    ACCOUNT_UN_LOGIN("account_un_login","账号未登录"),

    /**
     * 短链
     */
    SHORT_LINK_NOT_EXIST("short_link_not_exist","短链不存在"),

    /**
     * 订单
     */
    ORDER_CONFIRM_PRICE_FAIL("order_confirm_price_fail","创建订单-验价失败"),

    ORDER_CONFIRM_REPEAT("order_confirm_repeat","订单恶意-重复提交"),

    ORDER_CONFIRM_TOKEN_EQUAL_FAIL("order_confirm_token_equal_fail","订单令牌缺少"),

    ORDER_NOT_EXIST("order_not_exist","订单不存在"),
    /**
     * ⽀付
     */
    PAY_ORDER_FAIL("pay_order_fail","创建⽀付订单失败"),

    PAY_ORDER_CALLBACK_SIGN_FAIL("pay_order_callback_sign_fail","⽀付订单回调验证签失败"),

    PAY_ORDER_CALLBACK_FAIL("pay_order_callback_fail","⽀付宝回调更新订单失败"),

    PAY_ORDER_NOT_EXIST("pay_order_not_exist","支付订单不存在"),

    PAY_ORDER_STATE_ERROR("pay_order_state_error","支付订单状态不正常"),

    PAY_ORDER_PAY_TIMEOUT("pay_order_pay_timeout","订单⽀付超时"),

    /**
     * 流控操作
     */
    CONTROL_FLOW("control_flow","限流控制"),

    CONTROL_DEGRADE("control_degrade","降级控制"),

    CONTROL_AUTH("control_auth","认证控制"),

    /**
     * 流量包操作
     */
    TRAFFIC_FREE_NOT_EXIST("traffic_free_not_exist","免费流量包不存在，请联系客服"),

    TRAFFIC_REDUCE_FAIL("traffic_reduce_fail","流量不⾜，扣减失败"),

    TRAFFIC_EXCEPTION("traffic_exception","流量包数据异常,⽤户⽆流量包"),

    /**
     * 通⽤操作码
     */
    OPS_REPEAT("ops_repeat","重复操作"),

    OPS_NETWORK_ADDRESS_ERROR("ops_network_address_error","⽹络地址错误"),

    /**
     * ⽂件相关
     */
    FILE_UPLOAD_USER_IMG_FAIL("file_upload_user_img_fail","⽤户头像⽂件上传失败");

    private final String code;
    private final String message;
}
