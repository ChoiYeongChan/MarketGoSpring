package com.example.marketgospring.repository;

import com.example.marketgospring.entity.MarketReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MarketReviewRepository extends JpaRepository<MarketReview, Long> {
    List<MarketReview> findByMarketId(Long marketId);

    List<MarketReview> findByMemberId(Long memberId);
}
