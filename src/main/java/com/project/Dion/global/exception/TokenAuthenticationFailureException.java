package com.project.Dion.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class TokenAuthenticationFailureException extends BusinessException{

    public static final TokenAuthenticationFailureException EXCEPTION = new TokenAuthenticationFailureException();

    private TokenAuthenticationFailureException() {
        super(HttpStatus.UNAUTHORIZED);
    }
}
