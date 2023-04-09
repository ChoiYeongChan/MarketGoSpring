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
    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member memberId;
    @Column
    private String memberName;
    @Column
    private double ratings;
    @Column
    private String reviewContent;
    @Column
    private LocalDateTime reviewDate;
    @OneToOne
    @JoinColumn(name = "market_review_file")
    private S3File marketReviewFile;
}
