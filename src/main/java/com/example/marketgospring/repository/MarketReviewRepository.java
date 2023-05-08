package com.example.marketgospring.repository;

import com.example.marketgospring.entity.MarketReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MarketReviewRepository extends JpaRepository<MarketReview, Integer> {
    @Query(value = "select m from MarketReview m where m.mrMarketId.marketId = :marketId")
    List<MarketReview> findByMrMarketId(@Param("marketId") Integer marketId);

    @Query(value = "select m from MarketReview m where m.mrMemberId.memberId = :memberId")
    List<MarketReview> findByMrMemberId(@Param("memberId") Integer memberId);
}
