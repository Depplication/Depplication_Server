package com.project.Dion.domain.user.presentation.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserUpdateResponse extends HttpResponse {

    private final String id;
    private final String name;
    private final String phone;
    private final String account;
    private final String address;

    public UserUpdateResponse(HttpStatus status,
                              String msg,
                              String id,
                              String name,
                              String phone,
                              String account,
                              String address) {
        super(status, msg);
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.account = account;
        this.address = address;
    }
}
