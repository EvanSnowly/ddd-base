package me.wuxuefeng.dddbase.infrastructure.config.web;

import lombok.extern.slf4j.Slf4j;
import me.wuxuefeng.dddbase.api.response.Result;
import me.wuxuefeng.dddbase.base.BaseErrorCode;
import me.wuxuefeng.dddbase.infrastructure.exception.UserErrorCode;
import me.wuxuefeng.dddbase.infrastructure.exception.UserException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 全局异常处理
 * <p>
 * 统一捕获系统内所有异常，返回标准响应对象
 * 该类属于基础设施层，不应依赖 domain 或 application
 * </p>
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义用户异常
     */
    @ExceptionHandler(UserException.class)
    public Result<String> handleUserException(UserException ex) {
        log.error("用户异常: code={}, message={}", ex.getErrorCode().getCode(), ex.getErrorCode().getMessage(), ex);
        return Result.failure(ex.getErrorCode());
    }

    /**
     * 处理所有未知异常
     */
    @ExceptionHandler(Throwable.class)
    public Result<String> handleException(Throwable ex) {
        log.error("未知异常: message={}", ex.getMessage(), ex);
        return Result.failure(BaseErrorCode.failCode());
    }

    /**
     * 处理参数异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleException(MethodArgumentNotValidException ex) {
        // 获取字段错误列表
        String msg = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> String.format("%s=%s: %s",
                        fieldError.getField(),
                        fieldError.getRejectedValue(),
                        fieldError.getDefaultMessage()))
                .collect(Collectors.joining("; "));
        log.error("参数校验失败: message={}", msg, ex);
        return Result.failure(UserErrorCode.USER_ARGUMENT_ERROR);
    }

}