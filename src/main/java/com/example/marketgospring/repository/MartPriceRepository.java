package com.example.marketgospring.repository;

import com.example.marketgospring.entity.MartPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MartPriceRepository extends JpaRepository<MartPrice, Integer> {

    List<MartPrice> findByGoodsNameContains(String goodsName);
}
