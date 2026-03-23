package me.wuxuefeng.dddbase.api.base;

/**
 * 业务结果状态码枚举
 * <p>
 * 用于标识 API 调用的处理结果。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
public enum ResultCode {
    /** 操作成功 */
    SUCCESS(200, "操作成功"),
    /** 默认业务异常 */
    FAILURE(500, "业务异常"),
    /** 权限不足 */
    UNAUTHORIZED(401, "暂无权限"),
    /** 资源未找到 */
    NOT_FOUND(404, "资源不存在"),
    /** 参数错误 */
    PARAM_ERROR(400, "参数校验失败");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
