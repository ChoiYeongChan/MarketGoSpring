package com.example.marketgospring.repository;

import com.example.marketgospring.entity.StoreReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StoreReviewRepository extends JpaRepository<StoreReview, Integer> {
    List<StoreReview> findByStoreId(Integer storeId);

    List<StoreReview> findByMemberId(Integer memberId);
}
