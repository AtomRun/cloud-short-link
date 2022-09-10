package com.leeup.link.common.handler;

import com.leeup.link.common.Response;
import com.leeup.link.common.exception.RequestException;
import com.leeup.link.common.exception.ServerException;
import com.leeup.link.common.exception.ValidatedFieldError;
import com.leeup.link.common.exception.error.RequestError;
import com.leeup.link.common.exception.error.ServerError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 * Rest请求异常处理
 *
 * @author liu.yj
 * @since 2022/1/9 17:17
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public <T> Response<T> handleException(RequestException e) {
        log.error("Handle RequestException: {}-{}", e.getCode(), e.getMessage());
        return Response.error(e);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<List<ValidatedFieldError>> handleException(IllegalArgumentException e) {
        log.error("Handle IllegalArgumentException: ", e);
        return Response.error(RequestError.PARAMETER_ERROR.args(e.getMessage()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<List<ValidatedFieldError>> handleException(BindException e) {
        log.error("Handle BindException: ", e);
        return handleBindingResult(e.getBindingResult());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<List<ValidatedFieldError>> handleException(MethodArgumentNotValidException e) {
        log.error("Handle MethodArgumentNotValidException: ", e);
        return handleBindingResult(e.getBindingResult());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<List<ValidatedFieldError>> handleException(HttpMessageNotReadableException e) {
        log.error("Handle HttpMessageNotReadableException: ", e);
        return Response.error(RequestError.PARAMETER_ERROR.args(e.getMessage()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public <T> Response<T> handleException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        log.error("Handle MethodNotAllowedException: {}", requestURL, e);
        return Response.error(RequestError.METHOD_NOT_ALLOWED.args(e.getMethod(), requestURL));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public <T> Response<T> handleException(TimeoutException e) {
        log.error("Handle TimeoutException: ", e);
        return Response.error("timeout", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> Response<T> handleException(ServerException e) {
        log.error("Handle ServerException: {}-{}", e.getCode(), e.getMessage());
        return Response.error(e);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> Response<T> handleException(NullPointerException e) {
        log.error("Handle NullPointException: ", e);
        return Response.error(ServerError.SYSTEM_ERROR.args("NPE"));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @Order
    public <T> Response<T> handleException(RuntimeException e) {
        log.error("Handle RuntimeException: ", e);
        return Response.error(ServerError.SYSTEM_ERROR.args(e.getMessage()));
    }

    private Response<List<ValidatedFieldError>> handleBindingResult(BindingResult result) {
        String message = "";
        FieldError fieldError = result.getFieldError();
        ObjectError globalError = result.getGlobalError();

        if (null != fieldError) {
            message = fieldError.getField() + fieldError.getDefaultMessage();
        } else if (null != globalError) {
            message = globalError.getObjectName() + globalError.getDefaultMessage();
        }
        List<ValidatedFieldError> details = result
                .getFieldErrors()
                .stream()
                .map(err -> new ValidatedFieldError(err.getField(), err.getDefaultMessage()))
                .collect(Collectors.toList());
        return Response.error(RequestError.PARAMETER_ERROR.args(message), details);
    }
}
