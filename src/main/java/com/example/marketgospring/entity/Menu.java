package com.example.marketgospring.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "menu")
public class Menu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;
    @Column
    private String menuName;
    @ManyToOne
    @JoinColumn(name = "menu_store")
    private Store menuStore;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id1")
    private Goods goodsId1;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id2")
    private Goods goodsId2;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id3")
    private Goods goodsId3;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id4")
    private Goods goodsId4;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id5")
    private Goods goodsId5;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id6")
    private Goods goodsId6;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id7")
    private Goods goodsId7;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id8")
    private Goods goodsId8;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id9")
    private Goods goodsId9;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id10")
    private Goods goodsId10;
    /*@Column
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
    private Long goodsId10;*/
}
