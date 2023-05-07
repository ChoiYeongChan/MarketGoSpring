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
    private Integer goodsId;
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
    private Integer goodsPrice;
    @Column
    private String goodsUnit;
    @Column
    private String goodsInfo;
    @Column
    private LocalDateTime updateTime;
    @Column
    private String goodsOrigin;
    @Column
    private Integer isAvail;
}
