package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Market;
import com.example.marketgospring.entity.S3File;
import com.example.marketgospring.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/market")
public class MarketController {

    private MarketRepository marketRepository;
    @Autowired
    public MarketController(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @GetMapping(value="/all")
    public Iterable<Market> list() {
        return marketRepository.findAll();
    }

    @GetMapping(value="/{marketId}")
    public Optional<Market> findOne(@PathVariable("marketId") Long id) {
        return marketRepository.findById(id);
    }

    @GetMapping(value = "/marketName/{marketName}")
    public List<Market> findByName(@PathVariable("marketName") String marketName) {
        return marketRepository.findByMarketName(marketName);
    }
    @GetMapping(value = "/loc/{marketLocation}")
    public List<Market> findByLocation(@PathVariable("marketLocation") String marketLocation) {
        return marketRepository.findByMarketLocation(marketLocation);
    }
    @PostMapping
    public Market put(@RequestParam("marketName") String marketName, @RequestParam("marketAddress1") String marketAddress1, @RequestParam("marketAddress2") String marketAddress2, @RequestParam("marketLocation") String marketLocation, @RequestParam("marketLatitude") double marketLatitude, @RequestParam("marketLongitude") double marketLongitude, @RequestParam("marketRatings") double marketRatings, @RequestParam("marketInfo") String marketInfo, @RequestParam("parking") String parking, @RequestParam("toilet") String toilet, @RequestParam("marketPhonenum") String marketPhonenum, @RequestParam("marketGiftcard") String marketGiftcard, @RequestParam("marketFile")S3File marketFile) {
        final Market market=Market.builder()
                .marketName(marketName)
                .marketAddress1(marketAddress1)
                .marketAddress2(marketAddress2)
                .marketLocation(marketLocation)
                .marketLatitude(marketLatitude)
                .marketLongitude(marketLongitude)
                .marketRatings(marketRatings)
                .marketInfo(marketInfo)
                .parking(parking)
                .toilet(toilet)
                .marketPhonenum(marketPhonenum)
                .marketGiftcard(marketGiftcard)
                .marketFile(marketFile)
                .build();
        return marketRepository.save(market);
    }
    @PutMapping(value = "/{marketId}")
    public Market update(@PathVariable("marketId") Long marketId, @RequestParam("marketName") String marketName, @RequestParam("marketAddress1") String marketAddress1, @RequestParam("marketAddress2") String marketAddress2, @RequestParam("marketLocation") String marketLocation, @RequestParam("marketLatitude") double marketLatitude, @RequestParam("marketLongitude") double marketLongitude, @RequestParam("marketRatings") double marketRatings, @RequestParam("marketInfo") String marketInfo, @RequestParam("parking") String parking, @RequestParam("toilet") String toilet, @RequestParam("marketPhonenum") String marketPhonenum, @RequestParam("marketGiftcard") String marketGiftcard, @RequestParam("marketFile")S3File marketFile) {
        Optional<Market> market=marketRepository.findById(marketId);
        market.get().setMarketName(marketName);
        market.get().setMarketAddress1(marketAddress1);
        market.get().setMarketAddress2(marketAddress2);
        market.get().setMarketLocation(marketLocation);
        market.get().setMarketLatitude(marketLatitude);
        market.get().setMarketLongitude(marketLongitude);
        market.get().setMarketRatings(marketRatings);
        market.get().setMarketInfo(marketInfo);
        market.get().setParking(parking);
        market.get().setToilet(toilet);
        market.get().setMarketPhonenum(marketPhonenum);
        market.get().setMarketGiftcard(marketGiftcard);
        market.get().setMarketFile(marketFile);
        return marketRepository.save(market.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("marketId") Long marketId) {
        marketRepository.deleteById(marketId);
    }
}
