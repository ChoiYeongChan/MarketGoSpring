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
    @JoinColumn(name = "goods_market")
    private Market goodsMarket;
    @ManyToOne
    @JoinColumn(name = "goods_store")
    private Store goodsStore;
    @OneToOne
    @JoinColumn(name="goods_file")
    private S3File goodsFile;
    @Column
    private int goodsPrice;
    @Column
    private String goodsUnit;
    @ManyToOne
    @JoinColumn(name = "goods_category")
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
