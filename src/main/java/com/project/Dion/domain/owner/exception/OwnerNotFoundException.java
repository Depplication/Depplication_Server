package com.project.Dion.domain.owner.exception;

import com.project.Dion.global.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OwnerNotFoundException extends BusinessException {

    public static final OwnerNotFoundException EXCEPTION = new OwnerNotFoundException();

    private OwnerNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }

}
