package com.example.marketgospring.repository;

import com.example.marketgospring.entity.GoodsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDataRepository extends JpaRepository<GoodsData, Integer> {
    List<GoodsData> findByGoodsId(Integer goodsId);
}
