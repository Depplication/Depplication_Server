package com.project.Dion.domain.user.dto.request;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDeleteRequestDto {

    @NotNull
    private String pw;

    @Builder
    public UserDeleteRequestDto(String pw) {
        this.pw = pw;
    }
}
