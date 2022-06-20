package com.project.Dion.domain.owner.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OwnerUpdateResponse<T> extends HttpResponse {

    private T data;

    public OwnerUpdateResponse(HttpStatus status, String msg, T data) {
        super(status, msg);
        this.data = data;
    }
}
