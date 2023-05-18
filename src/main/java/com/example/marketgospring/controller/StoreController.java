package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Category;
import com.example.marketgospring.entity.Market;
import com.example.marketgospring.entity.S3File;
import com.example.marketgospring.entity.Store;
import com.example.marketgospring.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/store")
public class StoreController {

    private StoreRepository storeRepository;

    @Autowired
    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping(value = "/all")
    public Iterable<Store> list() {
        return storeRepository.findAll();
    }

    @GetMapping(value = "/{storeId}")
    public Optional<Store> pickOne(@PathVariable("storeId")Integer storeId) {
        return storeRepository.findById(storeId);
    }

    @GetMapping(value = "/storeName/{storeName}")
    public List<Store> findByStore(@PathVariable("storeName") String storeName) {
        return storeRepository.findByStoreName(storeName);
    }

    @GetMapping(value = "/marketId/{marketId}")
    public List<Store> findByStoreMarketId(@PathVariable("marketId") Integer storeMarketId) {
        return storeRepository.findByStoreMarketId(storeMarketId);
    }

    @GetMapping(value = "/storeCategory/{storeCategory}")
    public List<Store> findByStoreCategory(@PathVariable("storeCategory") String storeCategory) {
        return storeRepository.findByStoreCategory(storeCategory);
    }

    @PostMapping
    public Store put(@RequestParam("storeName") String storeName, @RequestParam("storeAddress1") String storeAddress1, @RequestParam("storeAddress2") String storeAddress2, @RequestParam("storeCategory")Category storeCategory, @RequestParam("storePhonenum") String storePhonenum, @RequestParam("storeInfo") String storeInfo, @RequestParam("cardAvail") String cardAvail, @RequestParam("localAvail") String localAvail, @RequestParam("storeNum") Integer storeNum, @RequestParam("marketId") Market marketId, @RequestParam("storeFile")S3File storeFile) {
        final Store store = Store.builder()
                .storeName(storeName)
                .storeAddress1(storeAddress1)
                .storeAddress2(storeAddress2)
                .storeCategory(storeCategory)
                .storeRatings(0.0F)
                .storePhonenum(storePhonenum)
                .storeInfo(storeInfo)
                .cardAvail(cardAvail)
                .localAvail(localAvail)
                .storeNum(storeNum)
                .storeMarketId(marketId)
                .storeFile(storeFile)
                .reviewCount(0)
                .build();
        return storeRepository.save(store);
    }

    @PutMapping(value = "/{storeId}")
    public Store update(@PathVariable("storeId") Integer storeId, @RequestParam("storeName") String storeName, @RequestParam("storeAddress1") String storeAddress1, @RequestParam("storeAddress2") String storeAddress2, @RequestParam("storeCategory")Category storeCategory, @RequestParam("storePhonenum") String storePhonenum, @RequestParam("storeInfo") String storeInfo, @RequestParam("cardAvail") String cardAvail, @RequestParam("localAvail") String localAvail, @RequestParam("storeNum") Integer storeNum, @RequestParam("marketId") Market marketId, @RequestParam("storeFile")S3File storeFile) {
        Optional<Store> store=storeRepository.findById(storeId);
        store.get().setStoreName(storeName);
        store.get().setStoreAddress1(storeAddress1);
        store.get().setStoreAddress2(storeAddress2);
        store.get().setStoreCategory(storeCategory);
        store.get().setStorePhonenum(storePhonenum);
        store.get().setStoreInfo(storeInfo);
        store.get().setCardAvail(cardAvail);
        store.get().setLocalAvail(localAvail);
        store.get().setStoreNum(storeNum);
        store.get().setStoreMarketId(marketId);
        store.get().setStoreFile(storeFile);
        return storeRepository.save(store.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("storeId")Integer storeId) {
        storeRepository.deleteById(storeId);
    }
}
