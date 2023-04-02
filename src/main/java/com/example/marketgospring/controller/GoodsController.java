package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Goods;
import com.example.marketgospring.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public Optional<Goods> findOne(@PathVariable ("goodsId") Long goodsId) {
        return goodsRepository.findById(goodsId);
    }

    @PostMapping
    public Goods put(@RequestParam ("goodsId") Long goodsId, @RequestParam("goodsName") String goodsName, @RequestParam("marketId") Long marketId, @RequestParam("storeId") Long storeId, @RequestParam("goodsPrice") int goodsPrice, @RequestParam("goodsUnit") String goodsUnit, @RequestParam("goodsCategory") String goodsCategory, @RequestParam("goodsInfo") String goodsInfo, @RequestParam("goodsOrigin") String goodsOrigin, @RequestParam("isAvail") int isAvail) {
        LocalDateTime now=LocalDateTime.now();
        return goodsRepository.save(new Goods(goodsId, goodsName,marketId,storeId,goodsPrice,goodsUnit,goodsCategory,goodsInfo,now,goodsOrigin,isAvail));
    }
}
