package com.example.marketgospring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "store")
public class Store {
    @Id
    private Long storeId;
    @Column
    private String storeName;
    @Column
    private String storeAddress1;
    @Column
    private String storeAddress2;
    @Column
    private double storeRatings;
    @Column
    private String storePhonenum;
    @Column
    private String storeInfo;
    @Column
    private String cardAvail;
    @Column
    private String localAvail;
    @Column
    private int storeNum;
    @Column
    private String marketName;
}
