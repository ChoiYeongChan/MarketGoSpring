package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Member;
import com.example.marketgospring.entity.S3File;
import com.example.marketgospring.entity.Store;
import com.example.marketgospring.entity.StoreReview;
import com.example.marketgospring.repository.StoreReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/storeReview")
public class StoreReviewController {

    private StoreReviewRepository storeReviewRepository;

    @Autowired
    public StoreReviewController(StoreReviewRepository storeReviewRepository) {
        this.storeReviewRepository=storeReviewRepository;
    }

    @GetMapping(value = "/all")
    public Iterable<StoreReview> list() {
        return storeReviewRepository.findAll();
    }
    @GetMapping(value = "/storeId/{storeId}")
    public List<StoreReview> findByStoreId (@PathVariable("storeId") Integer storeId) {
        return storeReviewRepository.findBySrStoreId(storeId);
    }

    @GetMapping(value = "/memberId/{memberId}")
    public List<StoreReview> findByMemberId (@PathVariable("memberId") Integer memberId) {
        return storeReviewRepository.findByStoreReviewMemberId(memberId);
    }

    @PostMapping
    public StoreReview put(@RequestParam("storeId") Store storeId, @RequestParam("memberId") Member memberId, @RequestParam("memberName")String memberName, @RequestParam("ratings")Float ratings, @RequestParam("reviewContent")String reviewContent, @RequestParam("storeReviewFile")S3File storeReviewFile) {
        final StoreReview storeReview=StoreReview.builder()
                .storeId(storeId)
                .memberId(memberId)
                .memberName(memberName)
                .ratings(ratings)
                .reviewContent(reviewContent)
                .reviewDate(LocalDateTime.now())
                .storeReviewFile(storeReviewFile)
                .build();
        return storeReviewRepository.save(storeReview);
    }

    @PutMapping(value = "/{storeReviewId}")
    public StoreReview update(@PathVariable("storeReviewId")Integer storeReviewId, @RequestParam("ratings")Float ratings, @RequestParam("reviewContent")String reviewContent, @RequestParam("storeReviewFile")S3File storeReviewFile) {
        Optional<StoreReview> storeReview=storeReviewRepository.findById(storeReviewId);
        storeReview.get().setRatings(ratings);
        storeReview.get().setReviewContent(reviewContent);
        storeReview.get().setReviewDate(LocalDateTime.now());
        storeReview.get().setStoreReviewFile(storeReviewFile);
        return storeReviewRepository.save(storeReview.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("storeReviewId")Integer storeReviewId) {
        storeReviewRepository.deleteById(storeReviewId);
    }
}
