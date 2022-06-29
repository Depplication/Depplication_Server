package com.project.Dion.global.token.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class TokenResponse<T> {

    private String code;
    private String msg;
    private T data;

    public TokenResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}