package com.example.marketgospring.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "store")
public class Store {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    @JoinColumn(name = "marketId")
    private Market marketId;
    @OneToOne
    @JoinColumn(name = "store_file")
    private S3File storeFile;
}
