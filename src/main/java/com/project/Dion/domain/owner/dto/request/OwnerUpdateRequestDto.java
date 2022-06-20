package com.project.Dion.domain.owner.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OwnerUpdateRequestDto {

    private String name;

    private String phone;

    private String address;

    private String store;

    @Builder
    public OwnerUpdateRequestDto(String name, String phone, String address, String store) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.store = store;
    }
}
