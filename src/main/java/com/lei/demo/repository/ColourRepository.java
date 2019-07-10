package com.lei.demo.repository;

import com.lei.demo.domain.Colour;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chris
 */
public interface ColourRepository extends JpaRepository<Colour, Integer> {

}
