package com.project.Dion.domain.user.presentation.dto.request;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoginRequest {

    @NotNull
    private String id;

    @NotNull
    private String pw;

    @Builder
    public UserLoginRequest(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
