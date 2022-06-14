package com.project.Dion.domain.owner.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OwnerLoginResponse<T> extends HttpResponse {

    private final T data;

    public OwnerLoginResponse(HttpStatus status, String msg, T data) {
        super(status, msg);
        this.data = data;
    }

}
