package me.wuxuefeng.dddbase.base;


public class BaseErrorCode implements ErrorCode {

    private String code;

    private String msg;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }

    public BaseErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseErrorCode() {
    }

    public static BaseErrorCode successCode() {
        return new BaseErrorCode("200", "请求成功");
    }
    public static BaseErrorCode failCode() {
        return new BaseErrorCode("500", "未知异常");
    }

}
