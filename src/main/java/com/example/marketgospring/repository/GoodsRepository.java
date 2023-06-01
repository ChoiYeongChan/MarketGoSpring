package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository <Goods, Integer> {

    @Query("select g from Goods g where g.goodsStore.storeId=:storeId and g.isAvail<>0")
    List<Goods> findByStoreId(@Param("storeId")Integer storeId);

    @Query("select g from Goods g where g.goodsMarket.marketId=:marketId and g.isAvail<>0")
    List<Goods> findByMarketId(@Param("marketId")Integer marketId);

    List<Goods> findByGoodsNameContains(String goodsName);
}
