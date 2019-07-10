package com.lei.demo.serviceImpl;

import com.lei.demo.domain.Shoes;
import com.lei.demo.repository.ShoesRepository;
import com.lei.demo.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Chris
 */
@Service
public class ShoesServiceImpl implements ShoesService {

    @Autowired
    private ShoesRepository shoesRepository;

    @Override
    public List<Shoes> getShoesList() {
        return shoesRepository.findAll();
    }

    @Override
    public Shoes findShoesById(Integer id) {
        return shoesRepository.findOne(id);
    }

    @Override
    @Transactional
    public Shoes saveShoes(Shoes shoes) {
        return shoesRepository.save(shoes);
    }

    @Override
    @Transactional
    public void deleteShoes(Integer id) {
        shoesRepository.delete(id);
    }
}
