package com.example.backend.handler;

import com.example.backend.api.CommonResult;
import com.example.backend.api.IErrorCode;
import com.example.backend.api.ResultCode;
import com.example.backend.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理自定义业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public CommonResult<?> handleBusinessException(BusinessException e) {
        return CommonResult.failed((long) e.getCode(), e.getMessage());
    }

    /**
     * 处理参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<?> handleValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        return CommonResult.failed(ResultCode.VALIDATE_FAILED.getCode(),message);
    }

    /**
     * 处理运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public CommonResult<?> handleRuntimeException(RuntimeException e) {
        log.error("运行时异常：", e);
        return CommonResult.failed(ResultCode.FAILED.getCode(), "服务器内部错误");
    }

    /**
     * 兜底异常
     */
    @ExceptionHandler(Exception.class)
    public CommonResult<?> handleException(Exception e) {
        log.error("系统异常：", e);
        return CommonResult.failed(ResultCode.FAILED.getCode(), "系统异常");
    }
}