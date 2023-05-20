package com.example.marketgospring.controller;

import com.example.marketgospring.entity.GoodsData;
import com.example.marketgospring.repository.GoodsDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/goodsData")
public class GoodsDataController {
    public GoodsDataRepository goodsDataRepository;

    @Autowired
    public GoodsDataController(GoodsDataRepository goodsDataRepository) {this.goodsDataRepository=goodsDataRepository;}

    @GetMapping(value = "/all")
    public Iterable<GoodsData> list() {return goodsDataRepository.findAll();}

    @GetMapping(value = "/{goodsId}")
    public Optional<GoodsData> findById(@PathVariable("goodsId") Integer goodsId) {
        return goodsDataRepository.findById(goodsId);
    }

    @PostMapping
    public GoodsData put(@RequestParam("goodsId") Integer goodsId) {
        final GoodsData goodsData=GoodsData.builder().goodsDataId(goodsId).build();
        return goodsDataRepository.save(goodsData);
    }
}
