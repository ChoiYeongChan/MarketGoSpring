package com.example.marketgospring.controller;

import com.example.marketgospring.entity.MartPrice;
import com.example.marketgospring.repository.MartPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/martPrice")
public class MartPriceController {
    private MartPriceRepository martPriceRepository;

    @Autowired
    public MartPriceController(MartPriceRepository martPriceRepository) {
        this.martPriceRepository = martPriceRepository;
    }

    @GetMapping(value = "/all")
    public Iterable<MartPrice> list() {
        return martPriceRepository.findAll();
    }

    @GetMapping(value = "/{goodsName}")
    public List<MartPrice> findByGoodsNameContaining(@PathVariable("goodsName") String goodsName) {
        String[] word=goodsName.split("\\s");
        List<MartPrice> martPriceList = new ArrayList<>();
        List<MartPrice> mart;
        for (int i=0;i < word.length; i++) {
            mart=martPriceRepository.findByGoodsNameContains(word[i]);
            for (int j = 0; j < mart.size(); j++) {
                martPriceList.add(mart.get(j));
            }
        }
        List<MartPrice> martPrices=martPriceList.stream().distinct().collect(Collectors.toList());
        return martPrices;
    }

    @PostMapping
    public MartPrice put(@RequestParam("goodsName") String goodsName, @RequestParam("price") Integer price, @RequestParam("source") String source) {
        final MartPrice martPrice=MartPrice.builder()
                .goodsName(goodsName)
                .price(price)
                .source(source)
                .updateTime(LocalDateTime.now())
                .build();
        return martPriceRepository.save(martPrice);
    }
    @PutMapping(value = "/{martPriceId}")
    public MartPrice update(@PathVariable("martPriceId") Integer martPriceId,@RequestParam("goodsName") String goodsName, @RequestParam("price") Integer price, @RequestParam("source") String source) {
        Optional<MartPrice> martPrice=martPriceRepository.findById(martPriceId);
        martPrice.get().setGoodsName(goodsName);
        martPrice.get().setPrice(price);
        martPrice.get().setSource(source);
        martPrice.get().setUpdateTime(LocalDateTime.now());
        return martPriceRepository.save(martPrice.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("martPriceId") Integer martPriceId) {
        martPriceRepository.deleteById(martPriceId);
    }
}
