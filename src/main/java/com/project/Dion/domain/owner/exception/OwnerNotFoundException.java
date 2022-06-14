package com.project.Dion.domain.owner.exception;

import com.project.Dion.global.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "업주 아이디를 찾지 못하였습니다")
public class OwnerNotFoundException extends BusinessException {

    public static final OwnerNotFoundException EXCEPTION = new OwnerNotFoundException();

    private OwnerNotFoundException() {
        super(HttpStatus.NOT_FOUND, "업주 아이디를 찾지 못하였습니다");
    }

}
