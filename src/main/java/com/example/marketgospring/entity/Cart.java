package com.example.marketgospring.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cart")
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    @Column
    private LocalDateTime cartDate;

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
    @Column
    private Integer unit1;
    @Column
    private Integer unit2;
    @Column
    private Integer unit3;
    @Column
    private Integer unit4;
    @Column
    private Integer unit5;
    @Column
    private Integer unit6;
    @Column
    private Integer unit7;
    @Column
    private Integer unit8;
    @Column
    private Integer unit9;
    @Column
    private Integer unit10;
}
