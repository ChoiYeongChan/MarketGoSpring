package com.example.marketgospring.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "market")
public class Market {
    @Id
    private Long marketId;
    @Column
    private String marketName;
    @Column
    private String marketAddress1;
    @Column
    private String marketAddress2;
    @Column
    private String marketLocation;
    @Column
    private double marketLatitude;
    @Column
    private double marketLongitude;
    @Column
    private double marketRatings;
    @Column
    private String marketInfo;
    @Column
    private String parking;
    @Column
    private String toilet;
    @Column
    private String marketPhonenum;
    @Column
    private String marketGiftcard;

}
