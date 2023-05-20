package com.example.marketgospring.repository;

import com.example.marketgospring.entity.GoodsData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsDataRepository extends JpaRepository<GoodsData, Integer> {
}
