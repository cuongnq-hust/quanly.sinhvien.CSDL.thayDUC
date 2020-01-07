package com.soict.service.impl;

import com.soict.model.Monhoc;
import com.soict.repository.MonhocRepository;
import com.soict.service.MonhocService;
import org.springframework.beans.factory.annotation.Autowired;

public class MonhocServiceImpl implements MonhocService {
    @Autowired
    MonhocRepository monhocRepository;
    @Override
    public Iterable<Monhoc> findAll() {
        return monhocRepository.findAll();
    }

    @Override
    public Monhoc findById(Long id) {
        return monhocRepository.findOne(id);
    }

    @Override
    public void save(Monhoc monhoc) {
         monhocRepository.save(monhoc);
    }

    @Override
    public void remove(Long id) {
          monhocRepository.delete(id);
    }
}
