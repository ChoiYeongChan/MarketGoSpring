package com.example.marketgospring.controller;

import com.example.marketgospring.entity.MarketIndex;
import com.example.marketgospring.entity.Member;
import com.example.marketgospring.entity.Store;
import com.example.marketgospring.repository.MarketIndexRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/marketIndex")
public class MarketIndexController {
    private MarketIndexRepository marketIndexRepository;

    @Autowired
    public MarketIndexController(MarketIndexRepository marketIndexRepository) {
        this.marketIndexRepository = marketIndexRepository;
    }

    @GetMapping(value="/all")
    public Iterable<MarketIndex> list() {
        return marketIndexRepository.findAll();
    }

    @GetMapping(value = "/{indexId}")
    public Optional<MarketIndex> findById(@PathVariable ("indexId") Integer indexId) {
        return marketIndexRepository.findById(indexId);
    }

    @GetMapping(value = "/memberId/{memberId}")
    public Optional<MarketIndex> findByMember(@PathVariable("memberId") Integer memberId) {
        return marketIndexRepository.findByMemberId(memberId);
    }

    @PostMapping
    public MarketIndex put(@RequestParam("memberId")Member memberId, @RequestParam("storeId1") Store storeId1, @RequestParam("storeId2") Store storeId2,@RequestParam("storeId3") Store storeId3,@RequestParam("storeId4") Store storeId4,@RequestParam("storeId5") Store storeId5,@RequestParam("storeId6") Store storeId6,@RequestParam("storeId7") Store storeId7,@RequestParam("storeId8") Store storeId8,@RequestParam("storeId9") Store storeId9,@RequestParam("storeId10") Store storeId10) {
        final MarketIndex marketIndex = MarketIndex.builder()
                .memberId(memberId)
                .storeId1(storeId1)
                .storeId2(storeId2)
                .storeId3(storeId3)
                .storeId4(storeId4)
                .storeId5(storeId5)
                .storeId6(storeId6)
                .storeId7(storeId7)
                .storeId8(storeId8)
                .storeId9(storeId9)
                .storeId10(storeId10)
                .build();
        return marketIndexRepository.save(marketIndex);
    }


    @PutMapping(value = "/{indexId}")
    public MarketIndex update(@PathVariable("indexId")Integer indexId, @RequestParam("memberId")Member memberId, @RequestParam("storeId1") Store storeId1, @RequestParam("storeId2") Store storeId2,@RequestParam("storeId3") Store storeId3,@RequestParam("storeId4") Store storeId4,@RequestParam("storeId5") Store storeId5,@RequestParam("storeId6") Store storeId6,@RequestParam("storeId7") Store storeId7,@RequestParam("storeId8") Store storeId8,@RequestParam("storeId9") Store storeId9,@RequestParam("storeId10") Store storeId10) {
        Optional<MarketIndex> marketIndex=marketIndexRepository.findById(indexId);
        marketIndex.get().setMemberId(memberId);
        marketIndex.get().setStoreId1(storeId1);
        marketIndex.get().setStoreId2(storeId2);
        marketIndex.get().setStoreId3(storeId3);
        marketIndex.get().setStoreId4(storeId4);
        marketIndex.get().setStoreId5(storeId5);
        marketIndex.get().setStoreId6(storeId6);
        marketIndex.get().setStoreId7(storeId7);
        marketIndex.get().setStoreId8(storeId8);
        marketIndex.get().setStoreId9(storeId9);
        marketIndex.get().setStoreId10(storeId10);
        return marketIndexRepository.save(marketIndex.get());
    }

    @DeleteMapping
    public void delete(@PathVariable("indexId")Integer indexId) {
        marketIndexRepository.deleteById(indexId);
    }
}
