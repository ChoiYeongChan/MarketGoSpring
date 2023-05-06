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
    private Integer memberId;
    @Column
    private String memberToken;
    @Column
    private String memberName;
    @ManyToOne
    @JoinColumn(name = "interest_market")
    private Market interestMarket;
    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cartId;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store storeId;
    @Column
    private Float recentLatitude;
    @Column
    private Float recentLongitude;
}
