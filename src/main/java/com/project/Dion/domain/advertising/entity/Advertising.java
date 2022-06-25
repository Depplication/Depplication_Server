package com.project.Dion.domain.advertising.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "dion_advertising")
public class Advertising {

    @Id
    private int idx;

    @NotNull
    @Column(nullable = false, name = "adName")
    private String name;

    @NotNull
    @Column(nullable = false, name = "storeName")
    private String storeName;

    @NotNull
    @Column(nullable = false, name = "ownerName")
    private String ownerName;

    @NotNull
    @Column(nullable = false, name = "registrationNumber")
    private String registrationNumber;

    @NotNull
    @Column(nullable = false, name = "email")
    private String ownerEmail;

    @NotNull
    @Column(nullable = false, name = "storeIntroMessage")
    private String storeIntroMsg;

    @NotNull
    @Column(nullable = false, name = "startDate")
    private Date startDate;

    @NotNull
    @Column(nullable = false, name = "endDate")
    private Date endDate;

    @Builder
    public Advertising(int idx, String name, String storeName, String ownerName, String registrationNumber, String ownerEmail, String storeIntroMsg, Date startDate, Date endDate) {
        this.idx = idx;
        this.name = name;
        this.storeName = storeName;
        this.ownerName = ownerName;
        this.registrationNumber = registrationNumber;
        this.ownerEmail = ownerEmail;
        this.storeIntroMsg = storeIntroMsg;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
