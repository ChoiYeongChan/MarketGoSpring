package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Market;
import com.example.marketgospring.entity.S3File;
import com.example.marketgospring.entity.Store;
import com.example.marketgospring.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Optional<Store> pickOne(@PathVariable("storeId")Long storeId) {
        return storeRepository.findById(storeId);
    }

    @PostMapping
    public Store put(@RequestParam("storeName") String storeName, @RequestParam("storeAddress1") String storeAddress1, @RequestParam("storeAddress2") String storeAddress2, @RequestParam("storeRatings") double storeRatings, @RequestParam("storePhonenum") String storePhonenum, @RequestParam("storeInfo") String storeInfo, @RequestParam("cardAvail") String cardAvail, @RequestParam("localAvail") String localAvail, @RequestParam("storeNum") int storeNum, @RequestParam("marketId") Market marketId, @RequestParam("storeFile")S3File storeFile) {
        final Store store = Store.builder()
                .storeName(storeName)
                .storeAddress1(storeAddress1)
                .storeAddress2(storeAddress2)
                .storeRatings(storeRatings)
                .storePhonenum(storePhonenum)
                .storeInfo(storeInfo)
                .cardAvail(cardAvail)
                .localAvail(localAvail)
                .storeNum(storeNum)
                .marketId(marketId)
                .storeFile(storeFile)
                .build();
        return storeRepository.save(store);
    }

    @PutMapping(value = "/{storeId}")
    public Store update(@PathVariable("storeId") Long storeId, @RequestParam("storeName") String storeName, @RequestParam("storeAddress1") String storeAddress1, @RequestParam("storeAddress2") String storeAddress2, @RequestParam("storeRatings") double storeRatings, @RequestParam("storePhonenum") String storePhonenum, @RequestParam("storeInfo") String storeInfo, @RequestParam("cardAvail") String cardAvail, @RequestParam("localAvail") String localAvail, @RequestParam("storeNum") int storeNum, @RequestParam("marketId") Market marketId, @RequestParam("storeFile")S3File storeFile) {
        Optional<Store> store=storeRepository.findById(storeId);
        store.get().setStoreName(storeName);
        store.get().setStoreAddress1(storeAddress1);
        store.get().setStoreAddress2(storeAddress2);
        store.get().setStoreRatings(storeRatings);
        store.get().setStorePhonenum(storePhonenum);
        store.get().setStoreInfo(storeInfo);
        store.get().setCardAvail(cardAvail);
        store.get().setLocalAvail(localAvail);
        store.get().setStoreNum(storeNum);
        store.get().setMarketId(marketId);
        store.get().setStoreFile(storeFile);
        return storeRepository.save(store.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("storeId")Long storeId) {
        storeRepository.deleteById(storeId);
    }
}
