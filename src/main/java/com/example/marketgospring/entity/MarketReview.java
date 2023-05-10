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
@Table(name = "market_review")
public class MarketReview {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer marketReviewId;
    @ManyToOne
    @JoinColumn(name = "mr_market_id")
    private Market mrMarketId;
    @ManyToOne
    @JoinColumn(name = "mr_member_id")
    private Member mrMemberId;
    @Column
    private Float ratings;
    @Column
    private String reviewContent;
    @Column
    private LocalDateTime reviewDate;
    @OneToOne
    @JoinColumn(name = "market_review_file")
    private S3File marketReviewFile;
}
