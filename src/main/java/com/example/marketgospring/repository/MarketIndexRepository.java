package com.example.marketgospring.repository;

import com.example.marketgospring.entity.MarketIndex;
import com.example.marketgospring.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketIndexRepository extends JpaRepository<MarketIndex, Integer> {
    List<MarketIndex> findByMemberId(Member memberId);
}
