package me.wuxuefeng.dddbase.base;

/**
 * 业务异常基类
 * <p>
 * 定义了系统中通用的业务异常处理规范。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
public class BizException extends RuntimeException {

    /** 错误码对象 */
    private ErrorCode errorCode;

    /**
     * 根据错误码构造异常
     *
     * @param errorCode 错误码
     */
    public BizException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    /**
     * 根据自定义消息和错误码构造异常
     *
     * @param message   自定义消息
     * @param errorCode 错误码
     */
    public BizException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 根据自定义消息、原因和错误码构造异常
     *
     * @param message   自定义消息
     * @param cause     异常原因
     * @param errorCode 错误码
     */
    public BizException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * 根据原因和错误码构造异常
     *
     * @param cause     异常原因
     * @param errorCode 错误码
     */
    public BizException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    /**
     * 完整构造函数
     *
     * @param message            自定义消息
     * @param cause              异常原因
     * @param enableSuppression  是否启用异常抑制
     * @param writableStackTrace 是否启用可写的堆栈跟踪
     * @param errorCode          错误码
     */
    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    /**
     * 获取错误码
     *
     * @return 错误码对象
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * 设置错误码
     *
     * @param errorCode 错误码对象
     */
    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
