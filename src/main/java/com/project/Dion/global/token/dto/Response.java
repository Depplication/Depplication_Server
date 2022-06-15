package com.project.Dion.global.token.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Response {

    private String code;
    private String msg;

    @Builder
    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
