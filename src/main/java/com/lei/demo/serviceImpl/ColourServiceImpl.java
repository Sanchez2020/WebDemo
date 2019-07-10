package com.lei.demo.serviceImpl;

import com.lei.demo.domain.Colour;
import com.lei.demo.repository.ColourRepository;
import com.lei.demo.service.ColourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Chris
 */
@Service
public class ColourServiceImpl implements ColourService {

    @Autowired
    private ColourRepository colourRepository;

    @Override
    public List<Colour> getColourList() {
        return colourRepository.findAll();
    }

    @Override
    public Colour findColourById(Integer id) {
        return colourRepository.findOne(id);
    }

    @Override
    @Transactional
    public Colour saveColour(Colour colour) {
        return colourRepository.save(colour);
    }

    @Override
    @Transactional
    public void deleteColour(Integer id) {
        colourRepository.delete(id);
    }
}
