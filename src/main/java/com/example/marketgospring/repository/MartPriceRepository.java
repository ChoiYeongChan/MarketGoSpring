package com.example.marketgospring.repository;

import com.example.marketgospring.entity.MartPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MartPriceRepository extends JpaRepository<MartPrice, Integer> {

    List<MartPrice> findByGoodsNameContains(String goodsName);
}
