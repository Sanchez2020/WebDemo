package com.lei.demo.repository;

import com.lei.demo.domain.Size;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chris
 */
public interface SizeRepository extends JpaRepository<Size, Integer> {
}
