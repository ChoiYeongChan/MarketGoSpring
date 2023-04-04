package com.example.marketgospring.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "member")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column
    private String memberToken;
    @Column
    private String memberName;
    @Column
    private String interestMarket;
    @Column
    private Long cartId;
    @Column
    private Long storeId;
    @Column
    private double recentLatitude;
    @Column
    private double recentLongitude;
}
