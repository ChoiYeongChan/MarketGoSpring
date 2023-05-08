package com.example.marketgospring.repository;

import com.example.marketgospring.entity.StoreReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StoreReviewRepository extends JpaRepository<StoreReview, Integer> {
    @Query(value = "select sr from StoreReview sr where sr.storeId.storeId = :storeId")
    List<StoreReview> findBySrStoreId(@Param("storeId") Integer storeId);

    @Query(value = "select sr from StoreReview sr where sr.memberId.memberId = :memberId")
    List<StoreReview> findByStoreReviewMemberId(@Param("memberId") Integer memberId);
}
