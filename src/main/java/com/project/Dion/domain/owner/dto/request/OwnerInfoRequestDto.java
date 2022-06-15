package com.project.Dion.domain.owner.dto.request;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OwnerInfoRequestDto {

    @NotNull
    private String id;

    @Builder
    public OwnerInfoRequestDto(String id) {
        this.id = id;
    }

}
