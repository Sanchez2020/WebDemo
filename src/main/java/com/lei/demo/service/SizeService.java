package com.lei.demo.service;

import com.lei.demo.domain.Size;

import java.util.List;

/**
 * @author Chris
 */
public interface SizeService {

    List<Size> getSizeList();

    Size findSizeById(Integer id);

    Size saveSize(Size size);

    void deleteSize(Integer id);
}
