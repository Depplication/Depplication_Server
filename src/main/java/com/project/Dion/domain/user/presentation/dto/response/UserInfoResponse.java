package com.project.Dion.domain.user.presentation.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserInfoResponse extends HttpResponse {

    private final String id;
    private final String pw;
    private final String name;
    private final String phone;
    private final String account;
    private final String address;

    public UserInfoResponse(HttpStatus status,
                            String msg,
                            String id,
                            String pw,
                            String name,
                            String phone,
                            String account,
                            String address) {
        super(status, msg);
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.account = account;
        this.address = address;
    }
}
