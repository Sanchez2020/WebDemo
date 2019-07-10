package com.lei.demo.repository;

import com.lei.demo.domain.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Chris
 */
public interface ShoesRepository  extends JpaRepository<Shoes, Integer>{
}
