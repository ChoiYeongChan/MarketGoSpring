package com.example.marketgospring.entity;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "goods")
public class Goods {
    @Id
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
