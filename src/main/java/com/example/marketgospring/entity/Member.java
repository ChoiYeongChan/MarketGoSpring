package com.example.marketgospring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class Member {
    @Id
    private String memberId;
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
