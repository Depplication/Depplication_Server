package com.project.Dion.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserUpdateRequestDto {

    private String name;

    private String phone;

    private String account;

    private String address;

    @Builder
    public UserUpdateRequestDto(String name, String phone, String account, String address) {
        this.name = name;
        this.phone = phone;
        this.account = account;
        this.address = address;
    }
}
