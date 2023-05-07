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
    private Integer storeId;
    @Column
    private String storeName;
    @Column
    private String storeAddress1;
    @Column
    private String storeAddress2;
    @ManyToOne
    @JoinColumn(name = "store_category")
    private Category storeCategory;
    @Column
    private Float storeRatings;
    @Column
    private String storePhonenum;
    @Column
    private String storeInfo;
    @Column
    private String cardAvail;
    @Column
    private String localAvail;
    @Column
    private Integer storeNum;
    @ManyToOne
    @JoinColumn(name = "store_market_id")
    private Market storeMarketId;
    @OneToOne
    @JoinColumn(name = "store_file")
    private S3File storeFile;
}
