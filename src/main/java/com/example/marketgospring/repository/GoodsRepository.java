package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository <Goods, Long> {
}
