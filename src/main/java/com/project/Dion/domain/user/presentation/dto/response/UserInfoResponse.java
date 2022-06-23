package com.project.Dion.domain.user.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserInfoResponse<T> extends HttpResponse {

    private T data;

    public UserInfoResponse(HttpStatus status, String msg, T data) {
        super(status, msg);
        this.data = data;
    }
}
