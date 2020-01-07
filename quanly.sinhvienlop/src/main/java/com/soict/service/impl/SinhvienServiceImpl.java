package com.soict.service.impl;

import com.soict.model.Sinhvien;
import com.soict.repository.SinhvienRepository;
import com.soict.service.SinhvienService;
import org.springframework.beans.factory.annotation.Autowired;

public class SinhvienServiceImpl implements SinhvienService {

    @Autowired
    SinhvienRepository sinhvienRepository;
    @Override
    public Iterable<Sinhvien> findAll() {
        return sinhvienRepository.findAll();
    }

    @Override
    public Sinhvien findById(Long id) {
        return sinhvienRepository.findOne(id);
    }

    @Override
    public void save(Sinhvien sinhvien) {
        sinhvienRepository.save(sinhvien);
    }

    @Override
    public void remove(Long id) {
        sinhvienRepository.delete(id);
    }

}
