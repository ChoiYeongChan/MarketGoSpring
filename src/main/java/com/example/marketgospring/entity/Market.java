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
@Table(name = "market")
public class Market {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer marketId;
    @Column
    private String marketName;
    @Column
    private String marketAddress1;
    @Column
    private String marketAddress2;
    @Column
    private String marketLocation;
    @Column
    private Float marketLatitude;
    @Column
    private Float marketLongitude;
    @Column
    private Float marketRatings;
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
    @Column
    private String marketType;
    @Column
    private LocalDateTime updateTime;
    @OneToOne
    @JoinColumn(name = "market_file")
    private S3File marketFile;
    @OneToOne
    @JoinColumn(name = "market_map")
    private S3File marketMap;
}
