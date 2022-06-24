package com.project.Dion.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "dion_users")
public class User {

    @Id
    private String id;

    @NotNull
    @Column(nullable = false, name = "password", length = 100)
    private String pw;

    @Column(name = "userName", length = 50)
    private String name;

    @NotNull
    @Column(nullable = false, name = "phoneNumber", length = 50)
    private String phone;

    @NotNull
    @Column(name = "accountNumber", length = 50)
    private String account;

    @NotNull
    @Column(name = "address")
    private String address;

    @Builder
    public User(String id, String pw, String name, String phone, String account, String address) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.account = account;
        this.address = address;
    }

}
