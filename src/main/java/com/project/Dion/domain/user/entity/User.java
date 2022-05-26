package com.project.Dion.domain.user.entity;

import com.project.Dion.domain.user.enums.Job;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "dion_users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    private String id;

    @Column(nullable = false, name = "password", length = 20)
    private String pw;

    @Column(name = "userName", length = 10)
    private String name;

    @Column(nullable = false, name = "phoneNumber", length = 11)
    private String phone;

    @Column(name = "accountNumber", length = 20)
    private String account;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Job job;

    @Builder
    public User(String id, String pw, String name, String phone, String account, Job job) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.account = account;
        this.job = job;
    }

}
