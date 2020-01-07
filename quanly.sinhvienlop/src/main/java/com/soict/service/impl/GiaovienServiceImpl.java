package com.soict.service.impl;

import com.soict.model.Giaovien;
import com.soict.repository.GiaovienRepository;
import com.soict.service.GiaovienService;
import org.springframework.beans.factory.annotation.Autowired;

public class GiaovienServiceImpl implements GiaovienService {
    @Autowired
    GiaovienRepository giaovienRepository;
    @Override
    public Iterable<Giaovien> findAll() {
        return giaovienRepository.findAll();
    }

    @Override
    public Giaovien findById(Long id) {
        return giaovienRepository.findOne(id);
    }

    @Override
    public void save(Giaovien giaovien) {
        giaovienRepository.save(giaovien);
    }

    @Override
    public void remove(Long id) {
        giaovienRepository.delete(id);
    }

}
