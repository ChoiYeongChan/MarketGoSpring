package com.example.marketgospring.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "goods_data")
public class GoodsData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer goodsDataId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="goods_data")
    private Goods goodsData;
}
