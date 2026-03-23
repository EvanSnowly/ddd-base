package me.wuxuefeng.dddbase.api.base;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 统一响应结果集
 * @param <T> 响应数据类型
 */
public record Result<T>(
                int code,
                String msg,
                @JsonInclude(JsonInclude.Include.NON_NULL) // 如果 data 为 null，则不序列化该字段
                T data,
                long timestamp
        ) {

    /** 成功返回 - 带数据 */
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data, System.currentTimeMillis());
    }

    /** 成功返回 - 不带数据 */
    public static <T> Result<T> success() {
        return success(null);
    }

    /** 失败返回 - 使用默认枚举 */
    public static <T> Result<T> failure(ResultCode resultCode) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage(), null, System.currentTimeMillis());
    }

    /** 失败返回 - 自定义消息 */
    public static <T> Result<T> failure(int code, String msg) {
        return new Result<>(code, msg, null, System.currentTimeMillis());
    }

    /** 失败返回 - 快速业务异常 */
    public static <T> Result<T> error(String msg) {
        return failure(ResultCode.FAILURE.getCode(), msg);
    }
}