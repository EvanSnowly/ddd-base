package me.wuxuefeng.dddbase.infrastructure.exception;

import me.wuxuefeng.dddbase.base.ErrorCode;

/**
 * 用户模块错误码枚举
 * <p>
 * 实现 {@link ErrorCode} 接口，定义用户业务相关的错误提示。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
public enum UserErrorCode implements ErrorCode {

    /**
     * 用户不存在
     */
    USER_EMPTY("USER_EMPTY", "用户不存在"),

    /**
     * 认证失败（账号或密码错误）
     */
    USER_AUTH_ERROR("USER_AUTH_ERROR", "账号密码错误"),
    /**
     * 用户已存在
     */
    USER_ALREADY_EXISTS("USER_ALREADY_EXISTS", "用户名已存在"),
    /**
     * 用户参数异常
     */
    USER_ARGUMENT_ERROR("USER_ARGUMENT_ERROR", "用户参数异常");

    private final String code;
    private final String message;

    UserErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
