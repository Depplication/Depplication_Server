package com.project.Dion.domain.user.entity;

import com.project.Dion.domain.user.enums.Job;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "dion_owners")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Owner {

    @Id
    private String id;

    @Column(nullable = false, name = "password", length = 20)
    private String pw;

    @Column(name = "ownerName", length = 10)
    private String name;

    @Column(nullable = false, name = "phoneNumber", length = 11)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Job job;

    @Column(nullable = false, name = "storeName", length = 100)
    private String store;

    @Column(nullable = false, name = "address")
    private String address;

    @Column(nullable = false, name = "businessNumber")
    private String business;

    @Builder
    public Owner(String id, String pw, String name, String phone, Job job, String store, String address, String business) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.job = job;
        this.store = store;
        this.address = address;
        this.business = business;
    }
}
