package com.project.Dion.domain.owner.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "dion_owners")
public class Owner {

    @Id
    private String id;

    @NotNull
    @Column(nullable = false, name = "password", length = 100)
    private String pw;

    @Column(name = "ownerName", length = 10)
    private String name;

    @NotNull
    @Column(nullable = false, name = "phoneNumber", length = 11)
    private String phone;

    @NotNull
    @Column(nullable = false, name = "storeName", length = 100)
    private String store;

    @NotNull
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
