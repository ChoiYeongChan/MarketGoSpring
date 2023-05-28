package com.example.marketgospring.controller;

import com.example.marketgospring.entity.GoodsData;
import com.example.marketgospring.repository.GoodsDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/goodsData")
public class GoodsDataController {
    private GoodsDataRepository goodsDataRepository;

    @Autowired
    public GoodsDataController(GoodsDataRepository goodsDataRepository) {this.goodsDataRepository=goodsDataRepository;}

    @GetMapping(value = "/all")
    public Iterable<GoodsData> list() {return goodsDataRepository.findAll();}

    @GetMapping(value = "/{goodsId}")
    public List<GoodsData> findByGoodsId(@PathVariable("goodsId") Integer goodsId) {
        return goodsDataRepository.findByGoodsId(goodsId);
    }

    @PostMapping
    public GoodsData put(@RequestParam("goodsId") Integer goodsId, @RequestParam("price") Integer price) {
        final GoodsData goodsData=GoodsData.builder()
                .goodsId(goodsId)
                .price(price)
                .updatedDate(LocalDateTime.now())
                .build();
        return goodsDataRepository.save(goodsData);
    }

    @PutMapping(value = "/{goodsId}")
    public GoodsData update(@PathVariable("goodsId") Integer goodsId, @RequestParam("price") Integer price) {
        Optional<GoodsData> goodsData = goodsDataRepository.findById(goodsId);
        goodsData.get().setGoodsId(goodsId);
        goodsData.get().setPrice(price);
        goodsData.get().setUpdatedDate(LocalDateTime.now());
        return goodsDataRepository.save(goodsData.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("goodsId") Integer goodsId) {
        goodsDataRepository.deleteById(goodsId);
    }
}
