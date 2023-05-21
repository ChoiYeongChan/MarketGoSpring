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
@Table(name = "mart_price")
public class MartPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer martPriceId;
    @Column
    private String goodsName;
    @Column
    private Integer price;
    @Column
    private String source;
    @Column
    private LocalDateTime updateTime;
}
