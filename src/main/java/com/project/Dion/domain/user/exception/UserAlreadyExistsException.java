package com.project.Dion.domain.user.exception;

import com.project.Dion.global.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "사용자가 존재합니다")
public class UserAlreadyExistsException extends BusinessException {

    public static final UserAlreadyExistsException EXCEPTION = new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "사용자가 존재합니다");
    }
}
