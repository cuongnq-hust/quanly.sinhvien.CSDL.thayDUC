package com.soict.service.impl;

import com.soict.model.*;
import com.soict.repository.SvlopRepository;
import com.soict.service.SvlopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class SvlopServiceImpl implements SvlopService {
    @Autowired
    SvlopRepository svlopRepository;
    @Override
    public Page<Svlop> findAll(Pageable pageable) {
        return svlopRepository.findAll(pageable);
    }

    @Override
    public Svlop findById(Long id) {
        return svlopRepository.findOne(id);
    }

    @Override
    public void save(Svlop svlop) {
         svlopRepository.save(svlop);
    }

    @Override
    public void remove(Long id) {
          svlopRepository.delete(id);
    }

//    @Override
//    public Page<Svlop> findAllByNameContaining(String name, Pageable pageable) {
//        return svlopRepository.findAllByNameContaining(name,pageable);
//    }



    @Override
    public Iterable<Svlop> findAllBySinhvien(Sinhvien sinhvien) {
        return svlopRepository.findAllBySinhvien(sinhvien);
    }

    @Override
    public Page<Svlop> findAllBySinhvien(Pageable pageable, Sinhvien sinhvien) {
        return svlopRepository.findAllBySinhvien(pageable,sinhvien);
    }
    @Override
    public Iterable<Svlop> findAllByLop(Lop lop) {
        return svlopRepository.findAllByLop(lop);
    }

    @Override
    public Page<Svlop> findAllByLop(Pageable pageable, Lop lop) {
        return svlopRepository.findAllByLop(pageable,lop);
    }



//    @Override
//    public Page<Svlop> findAllByOrderByPriceAsc(Pageable pageable) {
//        return svlopRepository.findAllByOrderByPriceAsc(pageable);
//    }
//
//    @Override
//    public Page<Svlop> findAllByOrderByPriceDesc(Pageable pageable) {
//        return svlopRepository.findAllByOrderByPriceDesc(pageable);
//    }
//
//    @Override
//    public Page<Svlop> findAllByOrderByDateOfPurchase(Pageable pageable) {
//        return svlopRepository.findAllByOrderByDateOfPurchase(pageable);
//    }
}
