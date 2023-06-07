package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Coupon;
import com.example.marketgospring.entity.Store;
import com.example.marketgospring.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/coupon")
public class CouponController {
    private CouponRepository couponRepository;

    @Autowired
    public CouponController(CouponRepository couponRepository) {this.couponRepository=couponRepository;}

    @GetMapping(value = "/all")
    public Iterable<Coupon> list() {
        return couponRepository.findAll();
    }

    @GetMapping(value = "/{couponId}")
    public List<Coupon> findByCouponId(@PathVariable("couponId") Integer couponId) {
        return couponRepository.findByCouponId(couponId);
    }

    @GetMapping(value = "/storeId/{storeId}")
    public List<Coupon> findByStoreId(@PathVariable("storeId") Integer storeId) {
        return couponRepository.findByStoreId(storeId);
    }

    @GetMapping(value = "/marketId/{marketId}")
    public List<Coupon> findByMarketId(@PathVariable("marketId") Integer marketId) {
        return couponRepository.findByMarketId(marketId);
    }

    @PostMapping
    public Coupon put(@RequestParam("storeId") Store storeId, @RequestParam("couponInfo") String couponInfo, @RequestParam("discount") String discount, @RequestParam("duration") String duration) {
        final Coupon coupon = Coupon.builder()
                .storeId(storeId)
                .couponInfo(couponInfo)
                .discount(discount)
                .duration(duration)
                .build();
        return couponRepository.save(coupon);
    }

    @PutMapping(value = "/{couponId}")
    public Coupon update(@PathVariable("couponId") Integer couponId, @RequestParam("storeId") Store storeId, @RequestParam("couponInfo") String couponInfo, @RequestParam("discount") String discount, @RequestParam("duration") String duration) {
        Optional<Coupon> coupon = couponRepository.findById(couponId);
        coupon.get().setStoreId(storeId);
        coupon.get().setCouponInfo(couponInfo);
        coupon.get().setDiscount(discount);
        coupon.get().setDuration(duration);
        return couponRepository.save(coupon.get());
    }

    @DeleteMapping
    public void delete(@PathVariable("couponId") Integer couponId) {
        couponRepository.deleteById(couponId);
    }
}
