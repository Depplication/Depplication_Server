package com.project.Dion.domain.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "dion_users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User {

    @Id
    private String id;

    @Column(nullable = false, name = "password", length = 100)
    private String pw;

    @Column(name = "userName", length = 50)
    private String name;

    @Column(nullable = false, name = "phoneNumber", length = 50)
    private String phone;

    @Column(name = "accountNumber", length = 50)
    private String account;

    @Builder
    public User(String id, String pw, String name, String phone, String account) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.account = account;
    }

}
