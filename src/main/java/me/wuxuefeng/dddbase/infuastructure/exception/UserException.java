package me.wuxuefeng.dddbase.infuastructure.exception;

import me.wuxuefeng.dddbase.base.BizException;
import me.wuxuefeng.dddbase.base.ErrorCode;

public class UserException extends BizException {
    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
