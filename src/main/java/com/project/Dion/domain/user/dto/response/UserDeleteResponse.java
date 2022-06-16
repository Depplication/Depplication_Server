package com.project.Dion.domain.user.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserDeleteResponse extends HttpResponse {

    public UserDeleteResponse(HttpStatus status, String msg) {
        super(status, msg);
    }
}
