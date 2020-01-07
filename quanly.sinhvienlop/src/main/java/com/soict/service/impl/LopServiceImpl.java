package com.soict.service.impl;

import com.soict.model.Monhoc;
import com.soict.model.Giaovien;
import com.soict.model.Lop;
import com.soict.repository.LopRepository;
import com.soict.service.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class LopServiceImpl implements LopService {



    @Autowired
    LopRepository lopRepository;
    @Override
    public Iterable<Lop> findAll() {
        return lopRepository.findAll();
    }

    @Override
    public Lop findById(Long id) {
        return lopRepository.findOne(id);
    }

    @Override
    public void save(Lop lop) {
        lopRepository.save(lop);
    }

    @Override
    public void remove(Long id) {
        lopRepository.delete(id);
    }

    @Override
    public Iterable<Lop> findAllByGiaovien(Giaovien giaovien) {
        return lopRepository.findAllByGiaovien(giaovien);
    }

    @Override
    public Page<Lop> findAllByGiaovien(Pageable pageable, Giaovien giaovien) {
        return lopRepository.findAllByGiaovien(pageable,giaovien);
    }
    @Override
    public Iterable<Lop> findAllByMonhoc(Monhoc monhoc) {
        return lopRepository.findAllByMonhoc(monhoc);
    }

    @Override
    public Page<Lop> findAllByMonhoc(Pageable pageable, Monhoc monhoc) {
        return lopRepository.findAllByMonhoc(pageable,monhoc);
    }


}
