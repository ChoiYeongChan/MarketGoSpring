package com.example.marketgospring.repository;

import com.example.marketgospring.entity.StoreReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreReviewRepository extends JpaRepository<StoreReview, Long> {
    List<StoreReview> findByStoreId(Long storeId);

    List<StoreReview> findByMemberId(Long memberId);
}
