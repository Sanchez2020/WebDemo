package com.lei.demo.service;

import com.lei.demo.domain.Colour;

import java.util.List;

/**
 * @author Chris
 */
public interface ColourService {

    List<Colour> getColourList();

    Colour findColourById(Integer id);

    Colour saveColour(Colour colour);

    void deleteColour(Integer id);
}
