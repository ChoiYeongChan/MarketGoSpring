package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository <Goods, Long> {
    //Optional<Goods> findByStoreId(Long storeId);

    //Optional<Goods> findByMarketId(Long marketId);
}
