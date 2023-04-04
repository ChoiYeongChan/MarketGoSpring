package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {


    void deleteByMemberId(Long memberId);

    Optional<Member> findByMemberToken(String memberToken);
}
