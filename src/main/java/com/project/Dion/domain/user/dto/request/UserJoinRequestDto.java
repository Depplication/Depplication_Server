package com.project.Dion.domain.user.dto.request;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJoinRequestDto {

    @NotNull
    private String id;

    @NotNull
    private String pw;

    @NotNull
    private String phone;

    @NotNull
    private String address;

    @NotNull
    private String account;

    private String name;

    @Builder
    public UserJoinRequestDto(String id, String pw, String phone, String address, String account, String name) {
        this.id = id;
        this.pw = pw;
        this.phone = phone;
        this.address = address;
        this.account = account;
        this.name = name;
    }
}
