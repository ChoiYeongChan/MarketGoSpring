package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
    List<Market> findByMarketName(String marketName);

    List<Market> findByMarketLocation(String marketLocation);
}
