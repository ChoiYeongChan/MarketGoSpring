package com.example.marketgospring.repository;

import com.example.marketgospring.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuRepository extends JpaRepository <Menu, Integer> {

    List<Menu> findByMenuStore(Integer storeId);
    //List<Menu> findByStoreId(Long storeId);
}
