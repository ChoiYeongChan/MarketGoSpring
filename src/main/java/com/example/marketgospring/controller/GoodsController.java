package com.example.marketgospring.controller;

import com.example.marketgospring.entity.*;
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
    public Optional<Goods> findByGoodsId(@PathVariable ("goodsId") Integer goodsId) {
        return goodsRepository.findById(goodsId);
    }

    @PostMapping
    public Goods put(@RequestParam("goodsName") String goodsName, @RequestParam("marketId") Market marketId, @RequestParam("storeId") Store storeId, @RequestParam("goodsPrice") Integer goodsPrice, @RequestParam("goodsUnit") String goodsUnit, @RequestParam("goodsInfo") String goodsInfo, @RequestParam("goodsOrigin") String goodsOrigin, @RequestParam("isAvail") Integer isAvail, @RequestParam("goodsFile")S3File goodsFile) {
        LocalDateTime now=LocalDateTime.now();
        final Goods goods=Goods.builder()
                .goodsName(goodsName)
                .goodsMarket(marketId)
                .goodsStore(storeId)
                .goodsPrice(goodsPrice)
                .goodsUnit(goodsUnit)
                .goodsInfo(goodsInfo)
                .updateTime(now)
                .goodsOrigin(goodsOrigin)
                .isAvail(isAvail)
                .goodsFile(goodsFile)
                .build();
        return goodsRepository.save(goods);
    }

    @PutMapping(value = "/{goodsId}")
    public Goods update(@PathVariable ("goodsId") Integer goodsId, @RequestParam("goodsName") String goodsName, @RequestParam("marketId") Market marketId, @RequestParam("storeId") Store storeId, @RequestParam("goodsPrice") Integer goodsPrice, @RequestParam("goodsUnit") String goodsUnit, @RequestParam("goodsInfo") String goodsInfo, @RequestParam("goodsOrigin") String goodsOrigin, @RequestParam("isAvail") Integer isAvail, @RequestParam("goodsFile")S3File goodsFile) {
        Optional<Goods> goods=goodsRepository.findById(goodsId);
        goods.get().setGoodsName(goodsName);
        goods.get().setGoodsMarket(marketId);
        goods.get().setGoodsStore(storeId);
        goods.get().setGoodsPrice(goodsPrice);
        goods.get().setGoodsUnit(goodsUnit);
        goods.get().setGoodsInfo(goodsInfo);
        LocalDateTime now=LocalDateTime.now();
        goods.get().setUpdateTime(now);
        goods.get().setGoodsOrigin(goodsOrigin);
        goods.get().setIsAvail(isAvail);
        goods.get().setGoodsFile(goodsFile);
        return goodsRepository.save(goods.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("goodsId") Integer goodsId) {
        goodsRepository.deleteById(goodsId);
    }
}
