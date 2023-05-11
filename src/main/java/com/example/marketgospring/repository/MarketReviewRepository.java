package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Market;
import com.example.marketgospring.entity.MarketReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarketReviewRepository extends JpaRepository<MarketReview, Integer> {
    @Query(value = "select m from MarketReview m where m.mrMarketId.marketId = :marketId")
    List<MarketReview> findByMrMarketId(@Param("marketId") Integer marketId);

    @Query(value = "select m from MarketReview m where m.mrMemberId.memberId = :memberId")
    List<MarketReview> findByMrMemberId(@Param("memberId") Integer memberId);

    @Modifying
    @Query(value = "update Market m set m.reviewCount=m.reviewCount+1 where m.marketId = :marketId")
    void addMarketReview(@Param("marketId") Integer marketId);

    @Modifying
    @Query(value = "update Market m set m.reviewCount=m.reviewCount-1 where m.marketId = :marketId")
    void subMarketReview(@Param("marketId") Integer marketId);

    @Query(value = "select mr.mrMarketId from MarketReview mr where mr.marketReviewId=:marketReviewId")
    Optional<Market> findByMarketReviewId(@Param("marketReviewId") Integer marketReviewId);

    @Modifying
    @Query(value = "update Market m set m.marketRatings=(select avg(mr.ratings) from MarketReview mr where mr.mrMarketId.marketId=:marketId) where m.marketId=:marketId")
    void setMarketRatings(@Param("marketId") Integer marketId);

}
