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
@Table(name = "storereview")
public class StoreReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeReviewId;
    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store storeId;
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
    @OneToOne
    @JoinColumn(name = "store_review_file")
    private S3File storeReviewFile;
}
