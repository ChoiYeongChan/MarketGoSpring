package com.example.marketgospring.controller;

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

    @PostMapping
    public Store put(@RequestParam("storeId") Long storeId, @RequestParam("storeName") String storeName, @RequestParam("storeAddress1") String storeAddress1, @RequestParam("storeAddress2") String storeAddress2, @RequestParam("storeRatings") double storeRatings, @RequestParam("storePhonenum") String storePhonenum, @RequestParam("storeInfo") String storeInfo, @RequestParam("cardAvail") String cardAvail, @RequestParam("localAvail") String localAvail, @RequestParam("storeNum") int storeNum, @RequestParam("marketName") String marketName) {
        return storeRepository.save(new Store(storeId,storeName, storeAddress1,storeAddress2,storeRatings,storePhonenum,storeInfo,cardAvail,localAvail,storeNum,marketName));
    }

    @PutMapping(value = "/{storeId}")
    public Store update(@PathVariable("storeId") Long storeId, @RequestParam("storeName") String storeName, @RequestParam("storeAddress1") String storeAddress1, @RequestParam("storeAddress2") String storeAddress2, @RequestParam("storeRatings") double storeRatings, @RequestParam("storePhonenum") String storePhonenum, @RequestParam("storeInfo") String storeInfo, @RequestParam("cardAvail") String cardAvail, @RequestParam("localAvail") String localAvail, @RequestParam("storeNum") int storeNum, @RequestParam("marketName") String marketName) {
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
        store.get().setMarketName(marketName);
        return storeRepository.save(store.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("storeId")Long storeId) {
        storeRepository.deleteById(storeId);
    }
}
