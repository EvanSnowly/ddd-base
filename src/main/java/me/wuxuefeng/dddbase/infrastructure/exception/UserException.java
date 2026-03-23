package me.wuxuefeng.dddbase.infrastructure.exception;

import me.wuxuefeng.dddbase.base.BizException;
import me.wuxuefeng.dddbase.base.ErrorCode;

/**
 * 用户业务模块自定义异常
 * <p>
 * 继承自统一业务异常类，用于处理用户登录、权限等业务场景中的异常情况。
 * </p>
 *
 * @author wuxuefeng
 * @since 1.0.0
 */
public class UserException extends BizException {

    /**
     * 构造函数
     *
     * @param errorCode 错误码枚举
     */
    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
