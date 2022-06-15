package com.project.Dion.domain.user.dto.response;

import com.project.Dion.domain.user.entity.User;
import com.project.Dion.global.response.HttpResponse;
import com.project.Dion.global.token.dto.TokenDataResponse;
import com.project.Dion.global.token.dto.TokenResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserLoginResponse<T> extends HttpResponse {

    private final T data;
    private final TokenResponse<TokenDataResponse> token;

    public UserLoginResponse(HttpStatus status, String msg, T data, TokenResponse<TokenDataResponse> token) {
        super(status, msg);
        this.data = data;
        this.token = token;
    }

}
