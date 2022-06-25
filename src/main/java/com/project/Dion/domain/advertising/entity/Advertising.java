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

    @Builder
    public Advertising(int idx, String name, String storeName) {
        this.idx = idx;
        this.name = name;
        this.storeName = storeName;
    }
}
