package me.wuxuefeng.dddbase.api.base;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 统一响应结果集
 * <p>
 * 定义了 API 接口的标准返回格式。
 * </p>
 *
 * @param code      业务响应状态码
 * @param msg       业务提示信息
 * @param data      具体业务负载数据
 * @param timestamp 响应生成的时间戳
 * @param <T>       响应数据类型
 * @author wuxuefeng
 * @since 1.0.0
 */
public record Result<T>(
        int code,
        String msg,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        T data,
        long timestamp
) {

    /**
     * 成功返回 - 带负载数据
     *
     * @param data 业务数据
     * @param <T>  数据类型
     * @return Result 实例
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data, System.currentTimeMillis());
    }

    /**
     * 成功返回 - 不带负载数据
     *
     * @param <T> 数据类型
     * @return Result 实例
     */
    public static <T> Result<T> success() {
        return success(null);
    }

    /**
     * 失败返回 - 使用预定义错误码枚举
     *
     * @param resultCode 错误码枚举
     * @param <T>        数据类型
     * @return Result 实例
     */
    public static <T> Result<T> failure(ResultCode resultCode) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage(), null, System.currentTimeMillis());
    }

    /**
     * 失败返回 - 自定义状态码与消息
     *
     * @param code 业务状态码
     * @param msg  业务消息
     * @param <T>  数据类型
     * @return Result 实例
     */
    public static <T> Result<T> failure(int code, String msg) {
        return new Result<>(code, msg, null, System.currentTimeMillis());
    }

    /**
     * 失败返回 - 快速业务异常提示
     *
     * @param msg 业务提示信息
     * @param <T> 数据类型
     * @return Result 实例
     */
    public static <T> Result<T> error(String msg) {
        return failure(ResultCode.FAILURE.getCode(), msg);
    }
}
