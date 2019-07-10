package com.lei.demo.service;

import com.lei.demo.domain.Shoes;

import java.util.List;

/**
 * @author Chris
 */
public interface ShoesService {

    List<Shoes> getShoesList();

    Shoes findShoesById(Integer id);

    Shoes saveShoes(Shoes shoes);

    void deleteShoes(Integer id);
}
