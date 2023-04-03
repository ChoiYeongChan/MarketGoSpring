package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Member;
import com.example.marketgospring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/member")
public class MemberController {
    private MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository=memberRepository;
    }
    @GetMapping(value = "/all")
    public Iterable<Member> list() {
        return memberRepository.findAll();
    }
    @GetMapping(value = "/{memberId}")
    public Optional<Member> findOne(@PathVariable ("memberId") String memberId) {
        return memberRepository.findByMemberId(memberId);
    }
    @PostMapping
    public Member put(@RequestParam ("memberId") String memberId, @RequestParam("memberName") String memberName, @RequestParam("interestMarket") String interestMarket, @RequestParam("cartId") Long cartId, @RequestParam("storeId") Long storeId, @RequestParam("recentLatitude") double recentLatitude, @RequestParam("recentLongitude") double recentLongitude) {
        return memberRepository.save(new Member(memberId,memberName,interestMarket,cartId,storeId,recentLatitude,recentLongitude));
    }
    @PutMapping(value = "/{memberId}")
    public Member update(@PathVariable("memberId") String memberId,  @RequestParam("memberName") String memberName, @RequestParam("interestMarket") String interestMarket, @RequestParam("cartId") Long cartId, @RequestParam("storeId") Long storeId, @RequestParam("recentLatitude") double recentLatitude, @RequestParam("recentLongitude") double recentLongitude) {
        Optional<Member> member = memberRepository.findByMemberId(memberId);
        member.get().setMemberName(memberName);
        member.get().setInterestMarket(interestMarket);
        member.get().setCartId(cartId);
        member.get().setStoreId(storeId);
        member.get().setRecentLatitude(recentLatitude);
        member.get().setRecentLongitude(recentLongitude);
        return memberRepository.save(member.get());
    }
    @DeleteMapping
    public void delete(@RequestParam("memberId") String memberId) {
        memberRepository.deleteByMemberId(memberId);
    }
}
