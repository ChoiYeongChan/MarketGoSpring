package com.example.marketgospring.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "menu")
public class Menu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;
    @Column
    private String menuName;
    @Column
    private Long storeId;
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

}
