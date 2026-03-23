package me.wuxuefeng.dddbase.base;

/**
 * 通用错误码接口
 * <p>
 * 所有业务模块的错误码枚举均需实现此接口，以便于统一异常处理。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
public interface ErrorCode {
    /**
     * 获取错误码标识
     *
     * @return 错误码字符串
     */
    String getCode();

    /**
     * 获取错误提示信息
     *
     * @return 错误消息字符串
     */
    String getMessage();
}
