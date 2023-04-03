package com.example.marketgospring.repository;

import com.example.marketgospring.entity.MarketReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketReviewRepository extends JpaRepository<MarketReview, Long> {
    List<MarketReview> findByMarketId(Long marketId);

    List<MarketReview> findByMemberId(Long memberId);
}
