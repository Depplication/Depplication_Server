package com.project.Dion.domain.user.presentation.dto.response;

import com.project.Dion.global.response.HttpResponse;
import com.project.Dion.global.token.dto.TokenDataResponse;
import com.project.Dion.global.token.dto.TokenResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserLoginResponse extends HttpResponse {

    private final String id;
    private final String pw;
    private final String name;
    private final String phone;
    private final String account;
    private final String address;
    private final TokenResponse<TokenDataResponse> token;

    public UserLoginResponse(HttpStatus status,
                             String msg,
                             String id,
                             String pw,
                             String name,
                             String phone,
                             String account,
                             String address,
                             TokenResponse<TokenDataResponse> token) {
        super(status, msg);
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.account = account;
        this.address = address;
        this.token = token;
    }

}
