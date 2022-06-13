package com.project.Dion.domain.owner.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "dion_owners")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Owner {

    @Id
    private String id;

    @Column(nullable = false, name = "password", length = 100)
    private String pw;

    @Column(name = "ownerName", length = 10)
    private String name;

    @Column(nullable = false, name = "phoneNumber", length = 11)
    private String phone;

    @Column(nullable = false, name = "storeName", length = 100)
    private String store;

    @Column(nullable = false, name = "address")
    private String address;

    @Builder
    public Owner(String id, String pw, String name, String phone, String store, String address) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.store = store;
        this.address = address;
    }
}
