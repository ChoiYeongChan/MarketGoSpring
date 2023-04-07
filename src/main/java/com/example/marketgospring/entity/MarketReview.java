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
@Table(name = "marketreview")
public class MarketReview {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marketReviewId;
    @ManyToOne
    @JoinColumn(name = "marketId")
    private Market marketId;
    @Column
    private Long memberId;
    @Column
    private String memberName;
    @Column
    private double ratings;
    @Column
    private String reviewContent;
    @Column
    private LocalDateTime reviewDate;
}
