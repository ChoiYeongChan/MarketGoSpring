package com.example.marketgospring.entity;

import jdk.jfr.Timestamp;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "goods")
public class Goods {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goodsId;
    @Column
    private String goodsName;
    @ManyToOne
    @JoinColumn(name = "marketId")
    private Market goodsMarket;
    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store goodsStore;
    @OneToOne
    @JoinColumn(name="fileId")
    private S3File goodsFile;
    @Column
    private int goodsPrice;
    @Column
    private String goodsUnit;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category goodsCategory;
    @Column
    private String goodsInfo;
    @Column
    private LocalDateTime updateTime;
    @Column
    private String goodsOrigin;
    @Column
    private int isAvail;
}
