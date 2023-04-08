package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Category;
import com.example.marketgospring.entity.Goods;
import com.example.marketgospring.entity.Market;
import com.example.marketgospring.entity.Store;
import com.example.marketgospring.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/goods")
public class GoodsController {
    private GoodsRepository goodsRepository;

    @Autowired
    public GoodsController(GoodsRepository goodsRepository) {
        this.goodsRepository=goodsRepository;
    }

    @GetMapping(value = "/all")
    public Iterable<Goods> list() {
        return goodsRepository.findAll();
    }

    @GetMapping(value = "/{goodsId}")
    public Optional<Goods> findByGoodsId(@PathVariable ("goodsId") Long goodsId) {
        return goodsRepository.findById(goodsId);
    }/*
    @GetMapping(value = "/storeId/{storeId}")
    public Optional<Goods> findByStoreId(@PathVariable ("storeId") Long storeId) {
        return goodsRepository.findByStoreId(storeId);
    }
    @GetMapping(value = "/marketId/{marketId}")
    public Optional<Goods> findByMarketId(@PathVariable("marketId") Long marketId) {
        return goodsRepository.findByMarketId(marketId);
    }*/
    @PostMapping
    public Goods put(@RequestParam("goodsName") String goodsName, @RequestParam("marketId") Market marketId, @RequestParam("storeId") Store storeId, @RequestParam("goodsPrice") int goodsPrice, @RequestParam("goodsUnit") String goodsUnit, @RequestParam("goodsCategory") Category goodsCategory, @RequestParam("goodsInfo") String goodsInfo, @RequestParam("goodsOrigin") String goodsOrigin, @RequestParam("isAvail") int isAvail) {
        LocalDateTime now=LocalDateTime.now();
        final Goods goods=Goods.builder()
                .goodsName(goodsName)
                .goodsMarket(marketId)
                .goodsStore(storeId)
                .goodsPrice(goodsPrice)
                .goodsUnit(goodsUnit)
                .goodsCategory(goodsCategory)
                .goodsInfo(goodsInfo)
                .updateTime(now)
                .goodsOrigin(goodsOrigin)
                .isAvail(isAvail)
                .build();
        return goodsRepository.save(goods);
    }

    @PutMapping(value = "/{goodsId}")
    public Goods update(@PathVariable ("goodsId") Long goodsId, @RequestParam("goodsName") String goodsName, @RequestParam("marketId") Market marketId, @RequestParam("storeId") Store storeId, @RequestParam("goodsPrice") int goodsPrice, @RequestParam("goodsUnit") String goodsUnit, @RequestParam("goodsCategory") Category goodsCategory, @RequestParam("goodsInfo") String goodsInfo, @RequestParam("goodsOrigin") String goodsOrigin, @RequestParam("isAvail") int isAvail) {
        Optional<Goods> goods=goodsRepository.findById(goodsId);
        goods.get().setGoodsName(goodsName);
        goods.get().setGoodsMarket(marketId);
        goods.get().setGoodsStore(storeId);
        goods.get().setGoodsPrice(goodsPrice);
        goods.get().setGoodsUnit(goodsUnit);
        goods.get().setGoodsCategory(goodsCategory);
        goods.get().setGoodsInfo(goodsInfo);
        LocalDateTime now=LocalDateTime.now();
        goods.get().setUpdateTime(now);
        goods.get().setGoodsOrigin(goodsOrigin);
        goods.get().setIsAvail(isAvail);
        return goodsRepository.save(goods.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("goodsId") Long goodsId) {
        goodsRepository.deleteById(goodsId);
    }
}
