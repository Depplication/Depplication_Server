package com.project.Dion.domain.owner.dto.request;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OwnerDeleteRequestDto {

    @NotNull
    private String pw;

    @Builder
    public OwnerDeleteRequestDto(String pw) {
        this.pw = pw;
    }
}
