package com.project.Dion.domain.owner.exception;

import com.project.Dion.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class OwnerAlreadyExistsException extends BusinessException {

    public static final OwnerAlreadyExistsException EXCEPTION = new OwnerAlreadyExistsException();

    private OwnerAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "업주가 존재합니다");
    }
}
