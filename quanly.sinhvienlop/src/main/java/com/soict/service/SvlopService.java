package com.soict.service;

import com.soict.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SvlopService  {
    Page<Svlop> findAll(Pageable pageable);
    Svlop findById(Long id);
    void save(Svlop svlop);
    void remove(Long id);
    Iterable<Svlop> findAllBySinhvien(Sinhvien sinhvien);
    Iterable<Svlop> findAllByLop(Lop lop);

    Page<Svlop> findAllBySinhvien(Pageable pageable, Sinhvien sinhvien);
    Page<Svlop> findAllByLop(Pageable pageable, Lop lop);

//    Page<Svlop> findAllByNameContaining(String name, Pageable pageable);
//    Page<Svlop> findAllByOrderByPriceAsc(Pageable pageable);
//    Page<Svlop> findAllByOrderByPriceDesc(Pageable pageable);
//
//    Page<Svlop> findAllByOrderByDateOfPurchase(Pageable pageable);

}
