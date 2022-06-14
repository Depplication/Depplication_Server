package com.project.Dion.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "��й�ȣ�� ���� �ʽ��ϴ�")
public class PasswordWrongException extends BusinessException {

    public static final PasswordWrongException EXCEPTION = new PasswordWrongException();

    private PasswordWrongException() {
        super(HttpStatus.BAD_REQUEST, "��й�ȣ�� ���� �ʽ��ϴ�");
    }

}
