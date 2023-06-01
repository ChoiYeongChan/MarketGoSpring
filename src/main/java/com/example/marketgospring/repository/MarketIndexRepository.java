package com.example.marketgospring.repository;

import com.example.marketgospring.entity.MarketIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarketIndexRepository extends JpaRepository<MarketIndex, Integer> {
    @Query("select i from MarketIndex i where i.memberId.memberId=:memberId")
    Optional<MarketIndex> findByMemberId(@Param("memberId") Integer memberId);
}
