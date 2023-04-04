package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository <Goods, Long> {
    List<Goods> findByStoreId(Long storeId);

    List<Goods> findByMarketId(Long marketId);
}
