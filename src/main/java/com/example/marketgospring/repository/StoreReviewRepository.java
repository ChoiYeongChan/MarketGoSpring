package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Market;
import com.example.marketgospring.entity.Store;
import com.example.marketgospring.entity.StoreReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreReviewRepository extends JpaRepository<StoreReview, Integer> {
    @Query(value = "select sr from StoreReview sr where sr.storeId.storeId = :storeId order by sr.reviewDate desc")
    List<StoreReview> findBySrStoreId(@Param("storeId") Integer storeId);

    @Query(value = "select sr from StoreReview sr where sr.memberId.memberId = :memberId")
    List<StoreReview> findByStoreReviewMemberId(@Param("memberId") Integer memberId);

    @Modifying
    @Query(value = "update Store s set s.reviewCount=s.reviewCount+1 where s.storeId = :storeId")
    void addStoreReview(@Param("storeId") Integer storeId);

    @Modifying
    @Query(value = "update Store s set s.reviewCount=s.reviewCount-1 where s.storeId = :storeId")
    void subStoreReview(@Param("storeId") Integer storeId);

    @Query(value = "select sr.storeId from StoreReview sr where sr.storeReviewId=:storeReviewId")
    Optional<Store> findByStoreReviewId(@Param("storeReviewId") Integer storeReviewId);

    @Modifying
    @Query(value = "update Store s set s.storeRatings=(select avg(sr.ratings) from StoreReview sr where sr.storeId.storeId=:storeId) where s.storeId=:storeId")
    void setStoreRatings(@Param("storeId") Integer storeId);

    @Modifying
    @Query(value = "update Store s set s.reviewCount=(select count(sr) from StoreReview sr where sr.storeId.storeId=:storeId) where s.storeId=:storeId")
    void countStoreReview(@Param("storeId") Integer storeId);
}
