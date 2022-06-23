package com.project.Dion.domain.user.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserJoinResponse<T> extends HttpResponse {

    private final T data;

    public UserJoinResponse(HttpStatus status, String msg, T data) {
        super(status, msg);
        this.data = data;
    }
}
