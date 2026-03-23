package me.wuxuefeng.dddbase.api.base;

public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILURE(500, "业务异常"),
    UNAUTHORIZED(401, "暂无权限"),
    NOT_FOUND(404, "资源不存在"),
    PARAM_ERROR(400, "参数校验失败");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() { return code; }
    public String getMessage() { return message; }
}