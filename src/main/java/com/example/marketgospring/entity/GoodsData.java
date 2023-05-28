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
@Table(name = "goods_data")
public class GoodsData {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer goodsDataId;
    @Column
    private Integer goodsId;
    @Column
    private Integer price;
    @Column
    private LocalDateTime updatedDate;
}
