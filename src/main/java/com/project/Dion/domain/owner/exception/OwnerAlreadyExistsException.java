package com.project.Dion.domain.owner.exception;

import com.project.Dion.global.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class OwnerAlreadyExistsException extends BusinessException {

    public static final OwnerAlreadyExistsException EXCEPTION = new OwnerAlreadyExistsException();

    private OwnerAlreadyExistsException() {
        super(HttpStatus.CONFLICT);
    }
}
