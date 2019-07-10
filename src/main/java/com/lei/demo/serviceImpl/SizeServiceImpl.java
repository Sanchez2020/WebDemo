package com.lei.demo.serviceImpl;

import com.lei.demo.domain.Size;
import com.lei.demo.repository.SizeRepository;
import com.lei.demo.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Chris
 */
@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> getSizeList() {
        return sizeRepository.findAll();
    }

    @Override
    public Size findSizeById(Integer id) {
        return sizeRepository.findOne(id);
    }

    @Override
    @Transactional
    public Size saveSize(Size size) {
        return sizeRepository.save(size);
    }

    @Override
    @Transactional
    public void deleteSize(Integer id) {
        sizeRepository.delete(id);
    }
}
