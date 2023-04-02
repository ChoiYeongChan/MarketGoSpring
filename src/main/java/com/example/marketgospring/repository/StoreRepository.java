package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository <Store, Long> {
}
