package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Menu;
import com.example.marketgospring.entity.Store;
import com.example.marketgospring.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/menu")
public class MenuController {
    private MenuRepository menuRepository;

    @Autowired
    public MenuController(MenuRepository menuRepository) {
        this.menuRepository=menuRepository;
    }

    @GetMapping(value = "/all")
    public Iterable<Menu> list() {
        return menuRepository.findAll();
    }
    @GetMapping(value = "/{menuId}")
    public Optional<Menu> pickOne(@PathVariable("menuId")Long menuId) {
        return menuRepository.findById(menuId);
    }
    @GetMapping(value = "/storeId/{storeId}")
    public List<Menu> findByStoreId (@PathVariable("storeId") Long storeId) {
        return menuRepository.findByStoreId(storeId);
    }

    @PostMapping
    public Menu put(@RequestParam("menuName") String menuName, @RequestParam("storeId") Store storeId, @RequestParam("goodsId1") Long goodsId1, @RequestParam("goodsId2") Long goodsId2, @RequestParam("goodsId3") Long goodsId3, @RequestParam("goodsId4") Long goodsId4, @RequestParam("goodsId5") Long goodsId5, @RequestParam("goodsId6") Long goodsId6, @RequestParam("goodsId7") Long goodsId7, @RequestParam("goodsId8") Long goodsId8, @RequestParam("goodsId9") Long goodsId9, @RequestParam("goodsId10") Long goodsId10) {
        final Menu menu=Menu.builder()
                .menuName(menuName)
                .menuStore(storeId)
                .goodsId1(goodsId1)
                .goodsId2(goodsId2)
                .goodsId3(goodsId3)
                .goodsId4(goodsId4)
                .goodsId5(goodsId5)
                .goodsId6(goodsId6)
                .goodsId7(goodsId7)
                .goodsId8(goodsId8)
                .goodsId9(goodsId9)
                .goodsId10(goodsId10)
                .build();
                return menuRepository.save(menu);
    }
    @PutMapping(value = ("/{menuId}"))
    public Menu update(@PathVariable("menuId") Long menuId, @RequestParam("menuName") String menuName, @RequestParam("storeId") Store storeId, @RequestParam("goodsId1") Long goodsId1,@RequestParam("goodsId2") Long goodsId2,@RequestParam("goodsId3") Long goodsId3,@RequestParam("goodsId4") Long goodsId4,@RequestParam("goodsId5") Long goodsId5,@RequestParam("goodsId6") Long goodsId6,@RequestParam("goodsId7") Long goodsId7,@RequestParam("goodsId8") Long goodsId8,@RequestParam("goodsId9") Long goodsId9,@RequestParam("goodsId10") Long goodsId10) {
        Optional<Menu> menu=menuRepository.findById(menuId);
        menu.get().setMenuName(menuName);
        menu.get().setMenuStore(storeId);
        menu.get().setGoodsId1(goodsId1);
        menu.get().setGoodsId2(goodsId2);
        menu.get().setGoodsId3(goodsId3);
        menu.get().setGoodsId4(goodsId4);
        menu.get().setGoodsId5(goodsId5);
        menu.get().setGoodsId6(goodsId6);
        menu.get().setGoodsId7(goodsId7);
        menu.get().setGoodsId8(goodsId8);
        menu.get().setGoodsId9(goodsId9);
        menu.get().setGoodsId10(goodsId10);
        return menuRepository.save(menu.get());
    }
    @DeleteMapping
    public void delete(@RequestParam("menuId")Long menuId) {
        menuRepository.deleteById(menuId);
    }
}
