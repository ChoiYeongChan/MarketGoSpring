package com.example.marketgospring.repository;

import com.example.marketgospring.entity.GoodsData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsDataRepository extends JpaRepository<GoodsData, Integer> {
    List<GoodsData> findByGoodsId(Integer goodsId);
}
