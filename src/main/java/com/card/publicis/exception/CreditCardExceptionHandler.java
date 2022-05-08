package com.card.publicis.exception;

import com.card.publicis.dto.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CreditCardExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String exMessage = String.format(" Invalid field : %s", ex.getBindingResult());
        ErrorMessage error = new ErrorMessage();
        error.setHttpCode(HttpStatus.BAD_REQUEST.value());
        error.setHttpMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        error.setMessage(exMessage);
        log.error(exMessage);
        return error;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleMessageNotReadableException(HttpMessageNotReadableException ex) {
        String exMessage = "Something went wrong";
        ErrorMessage error = new ErrorMessage();
        error.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setHttpMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        error.setMessage(exMessage);
        log.error(exMessage);
        return error;
    }

}
