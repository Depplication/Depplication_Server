package com.project.Dion.domain.user.dto.request;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfoRequestDto {

    @NotNull
    private String id;

    @Builder
    public UserInfoRequestDto(String id) {
        this.id = id;
    }

}
