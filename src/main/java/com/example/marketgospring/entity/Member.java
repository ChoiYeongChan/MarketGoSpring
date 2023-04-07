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
    @ManyToOne
    @JoinColumn(name = "marketId")
    private Market interestMarket;
    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cartId;
    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store storeId;
    @Column
    private double recentLatitude;
    @Column
    private double recentLongitude;
}
