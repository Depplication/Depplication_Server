package com.project.Dion.domain.user.dto.request;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoginRequestDto {

    @NotNull
    private String id;

    @NotNull
    private String pw;

    @Builder
    public UserLoginRequestDto(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
