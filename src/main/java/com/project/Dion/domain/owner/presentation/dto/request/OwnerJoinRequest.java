package com.project.Dion.domain.owner.presentation.dto.request;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OwnerJoinRequest {

    @NotNull
    private String id;

    @NotNull
    private String pw;

    @NotNull
    private String storeName;

    @NotNull
    private String phone;

    @NotNull
    private String address;

    @NotNull
    private String name;

    @Builder
    public OwnerJoinRequest(String id, String pw, String storeName, String phone, String address, String name) {
        this.id = id;
        this.pw = pw;
        this.storeName = storeName;
        this.phone = phone;
        this.address = address;
        this.name = name;
    }
}
