package com.example.marketgospring.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cart")
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @Column
    private LocalDateTime cartDate;
    @Column
    private Long goodsId1;
    @Column
    private Long goodsId2;
    @Column
    private Long goodsId3;
    @Column
    private Long goodsId4;
    @Column
    private Long goodsId5;
    @Column
    private Long goodsId6;
    @Column
    private Long goodsId7;
    @Column
    private Long goodsId8;
    @Column
    private Long goodsId9;
    @Column
    private Long goodsId10;
    @Column
    private int unit1;
    @Column
    private int unit2;
    @Column
    private int unit3;
    @Column
    private int unit4;
    @Column
    private int unit5;
    @Column
    private int unit6;
    @Column
    private int unit7;
    @Column
    private int unit8;
    @Column
    private int unit9;
    @Column
    private int unit10;
}
