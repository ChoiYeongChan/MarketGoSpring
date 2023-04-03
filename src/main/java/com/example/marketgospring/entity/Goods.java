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
    @Column
    private Long marketId;
    @Column
    private Long storeId;
    @Column
    private int goodsPrice;
    @Column
    private String goodsUnit;
    @Column
    private String goodsCategory;
    @Column
    private String goodsInfo;
    @Column
    private LocalDateTime updateTime;
    @Column
    private String goodsOrigin;
    @Column
    private int isAvail;
}