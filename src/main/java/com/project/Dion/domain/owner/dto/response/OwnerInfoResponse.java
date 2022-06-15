package com.project.Dion.domain.owner.dto.response;

import com.project.Dion.global.response.HttpResponse;
import org.springframework.http.HttpStatus;

public class OwnerInfoResponse<T> extends HttpResponse {

    private T data;

    public OwnerInfoResponse(HttpStatus status, String msg, T data) {
        super(status, msg);
        this.data = data;
    }
}
