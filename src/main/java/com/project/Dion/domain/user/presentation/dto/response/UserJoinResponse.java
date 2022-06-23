package com.project.Dion.domain.user.presentation.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserJoinResponse extends HttpResponse {

    public UserJoinResponse(HttpStatus status, String msg) {
        super(status, msg);
    }
}
