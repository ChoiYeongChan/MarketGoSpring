package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Cart;
import com.example.marketgospring.entity.Market;
import com.example.marketgospring.entity.Member;
import com.example.marketgospring.entity.Store;
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
    public Optional<Member> findOne(@PathVariable ("memberId") Long memberId) {
        return memberRepository.findById(memberId);
    }
    @GetMapping(value = "/memberToken/{memberToken}")
    public Optional<Member> findByToken(@PathVariable("memberToken")String memberToken) {
        return memberRepository.findByMemberToken(memberToken);
    }
    @PostMapping
    public Member put(@RequestParam ("memberToken") String memberToken, @RequestParam("memberName") String memberName, @RequestParam("interestMarket") Market interestMarket, @RequestParam("cartId") Cart cartId, @RequestParam("storeId") Store storeId, @RequestParam("recentLatitude") double recentLatitude, @RequestParam("recentLongitude") double recentLongitude) {
        final Member member= Member.builder()
                .memberToken(memberToken)
                .memberName(memberName)
                .interestMarket(interestMarket)
                .cartId(cartId)
                .storeId(storeId)
                .recentLatitude(recentLatitude)
                .recentLongitude(recentLongitude)
                .build();
        return memberRepository.save(member);
    }
    @PutMapping(value = "/{memberId}")
    public Member update(@PathVariable("memberId") Long memberId, @RequestParam("memberName") String memberName, @RequestParam("interestMarket") Market interestMarket, @RequestParam("cartId") Cart cartId, @RequestParam("storeId") Store storeId, @RequestParam("recentLatitude") double recentLatitude, @RequestParam("recentLongitude") double recentLongitude) {
        Optional<Member> member = memberRepository.findById(memberId);
        member.get().setMemberName(memberName);
        member.get().setInterestMarket(interestMarket);
        member.get().setCartId(cartId);
        member.get().setStoreId(storeId);
        member.get().setRecentLatitude(recentLatitude);
        member.get().setRecentLongitude(recentLongitude);
        return memberRepository.save(member.get());
    }
    @DeleteMapping
    public void delete(@RequestParam("memberId") Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
