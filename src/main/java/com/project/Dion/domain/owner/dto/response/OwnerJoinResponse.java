package com.project.Dion.domain.owner.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OwnerJoinResponse<T> extends HttpResponse {

    private final T data;

    public OwnerJoinResponse(HttpStatus status, String msg, T data) {
        super(status, msg);
        this.data = data;
    }

}
