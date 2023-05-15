package com.example.marketgospring.controller;

import com.example.marketgospring.entity.MartPrice;
import com.example.marketgospring.repository.MartPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

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

    @PostMapping
    public MartPrice put(@RequestParam("goodsName") String goodsName, @RequestParam("price") Integer price, @RequestParam("unit") String unit) {
        final MartPrice martPrice=MartPrice.builder()
                .goodsName(goodsName)
                .price(price)
                .unit(unit)
                .updateTime(LocalDateTime.now())
                .build();
        return martPriceRepository.save(martPrice);
    }
    @PutMapping(value = "/{martPriceId}")
    public MartPrice update(@PathVariable("martPriceId") Integer martPriceId,@RequestParam("goodsName") String goodsName, @RequestParam("price") Integer price, @RequestParam("unit") String unit) {
        Optional<MartPrice> martPrice=martPriceRepository.findById(martPriceId);
        martPrice.get().setGoodsName(goodsName);
        martPrice.get().setPrice(price);
        martPrice.get().setUnit(unit);
        martPrice.get().setUpdateTime(LocalDateTime.now());
        return martPriceRepository.save(martPrice.get());
    }

    @DeleteMapping(value = "/{martPriceId}")
    public void delete(@PathVariable("martPriceId") Integer martPriceId) {
        martPriceRepository.deleteById(martPriceId);
    }
}
