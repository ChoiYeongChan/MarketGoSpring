package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Market;
import com.example.marketgospring.entity.MarketReview;
import com.example.marketgospring.entity.Member;
import com.example.marketgospring.entity.S3File;
import com.example.marketgospring.repository.MarketReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/marketReview")
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
    public List<MarketReview> findByMarketId(@PathVariable("marketId") Integer marketId) {
        return marketReviewRepository.findByMrMarketId(marketId);
    }

    @GetMapping(value = "/memberId/{memberId}")
    public List<MarketReview> findByMemberId (@PathVariable("memberId")Integer MemberId) {
        return marketReviewRepository.findByMrMemberId(MemberId);
    }

    @PostMapping
    public MarketReview put(@RequestParam("marketId") Market marketId, @RequestParam("memberId") Member memberId, @RequestParam("memberName")String memberName, @RequestParam("ratings")Float ratings, @RequestParam("reviewContent")String reviewContent, @RequestParam("marketReviewFile") S3File marketReviewFile) {
        final MarketReview marketReview=MarketReview.builder()
                .mrMarketId(marketId)
                .mrMemberId(memberId)
                .memberName(memberName)
                .ratings(ratings)
                .reviewContent(reviewContent)
                .reviewDate(LocalDateTime.now())
                .marketReviewFile(marketReviewFile)
                .build();
        return marketReviewRepository.save(marketReview);
    }

    @PutMapping(value = "/{marketReviewId}")
    public MarketReview update(@PathVariable("marketReviewId")Integer marketReviewId, @RequestParam("ratings")Float ratings, @RequestParam("reviewContent")String reviewContent, @RequestParam("marketReviewFile") S3File marketReviewFile) {
        Optional<MarketReview> marketReview=marketReviewRepository.findById(marketReviewId);
        marketReview.get().setRatings(ratings);
        marketReview.get().setReviewContent(reviewContent);
        marketReview.get().setReviewDate(LocalDateTime.now());
        marketReview.get().setMarketReviewFile(marketReviewFile);
        return marketReviewRepository.save(marketReview.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("marketReviewId")Integer marketReviewId) {
        marketReviewRepository.deleteById(marketReviewId);
    }
}
