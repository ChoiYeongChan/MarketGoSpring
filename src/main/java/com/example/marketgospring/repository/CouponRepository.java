package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    List<Coupon> findByCouponId(Integer couponId);

    List<Coupon> findByStoreId(Integer storeId);

    @Query("select c from Coupon c where c.storeId.storeMarketId.marketId=:marketId")
    List<Coupon> findByMarketId(@Param("marketId") Integer marketId);
}
