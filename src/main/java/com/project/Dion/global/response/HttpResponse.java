package com.project.Dion.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpResponse {

    private final HttpStatus status;
    private final String msg;

    public HttpResponse(HttpStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
