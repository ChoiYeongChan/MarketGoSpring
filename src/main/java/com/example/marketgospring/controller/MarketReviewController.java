package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Market;
import com.example.marketgospring.entity.MarketReview;
import com.example.marketgospring.repository.MarketReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/marketreview")
public class MarketReviewController {
    private MarketReviewRepository marketReviewRepository;

    @Autowired
    public MarketReviewController(MarketReviewRepository marketReviewRepository) {
        this.marketReviewRepository=marketReviewRepository;
    }

    @GetMapping(value = "/all")
    public Iterable<MarketReview> list() {
        return marketReviewRepository.findAll();
    }
    @GetMapping(value = "/marketId/{marketId}")
    public List<MarketReview> findByMarketId (@PathVariable("marketId")Long marketId) {
        return marketReviewRepository.findByMarketId(marketId);
    }

    @GetMapping(value = "/memberId/{memberId}")
    public List<MarketReview> findByMemberId (@PathVariable("memberId")Long memberId) {
        return marketReviewRepository.findByMemberId(memberId);
    }

    @PostMapping
    public MarketReview put(@RequestParam("marketId") Market marketId, @RequestParam("memberId")Long memberId, @RequestParam("memberName")String memberName, @RequestParam("ratings")double ratings, @RequestParam("reviewContent")String reviewContent) {
        final MarketReview marketReview=MarketReview.builder()
                .marketId(marketId)
                .memberId(memberId)
                .memberName(memberName)
                .ratings(ratings)
                .reviewContent(reviewContent)
                .reviewDate(LocalDateTime.now())
                .build();
        return marketReviewRepository.save(marketReview);
    }

    @PutMapping(value = "/{marketReviewId}")
    public MarketReview update(@PathVariable("marketReviewId")Long marketReviewId, @RequestParam("ratings")double ratings, @RequestParam("reviewContent")String reviewContent) {
        Optional<MarketReview> marketReview=marketReviewRepository.findById(marketReviewId);
        marketReview.get().setRatings(ratings);
        marketReview.get().setReviewContent(reviewContent);
        marketReview.get().setReviewDate(LocalDateTime.now());
        return marketReviewRepository.save(marketReview.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("marketReviewId")Long marketReviewId) {
        marketReviewRepository.deleteById(marketReviewId);
    }
}
