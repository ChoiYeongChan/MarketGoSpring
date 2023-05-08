package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Market;
import com.example.marketgospring.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository <Store, Integer> {
    List<Store> findByStoreName(String storeName);

    @Query(value = "select st from Store st where st.storeMarketId.marketId = :storeMarketId")
    List<Store> findByStoreMarketId(@Param("storeMarketId") Integer storeMarketId);

    @Query(value = "select st from Store st where st.storeCategory.categoryName = :storeCategory")
    List<Store> findByStoreCategory(@Param("storeCategory") String storeCategory);
}
