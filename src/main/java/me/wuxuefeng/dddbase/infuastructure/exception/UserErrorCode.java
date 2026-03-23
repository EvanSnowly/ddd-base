package me.wuxuefeng.dddbase.infuastructure.exception;

import me.wuxuefeng.dddbase.base.ErrorCode;

public enum UserErrorCode implements ErrorCode {

    /**
     * 用户不存在
     */
    USER_EMPTY("USER_EMPTY", "用户不存在"),
    /**
     * 用户不存在
     */
    USER_AUTH_ERROR("USER_AUTH_ERROR", "账号密码错误"),
    ;

    private String code;

    private String message;

    UserErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return "";
    }

    @Override
    public String getMessage() {
        return "";
    }
}
