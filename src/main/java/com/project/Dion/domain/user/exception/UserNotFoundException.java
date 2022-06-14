package com.project.Dion.domain.user.exception;

import com.project.Dion.global.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "아이디를 찾지 못하였습니다")
public class UserNotFoundException extends BusinessException {

    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "아이디를 찾지 못하였습니다");
    }

}
