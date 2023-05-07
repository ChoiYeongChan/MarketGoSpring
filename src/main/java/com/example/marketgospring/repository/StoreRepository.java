package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Market;
import com.example.marketgospring.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository <Store, Integer> {
    List<Store> findByStoreName(String storeName);

}
