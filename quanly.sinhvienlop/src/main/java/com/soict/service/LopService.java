package com.soict.service;

import com.soict.model.Monhoc;
import com.soict.model.Giaovien;
import com.soict.model.Lop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LopService {

//    Page<Lop> findAll(Pageable pageable);

    Iterable<Lop> findAll();
    Lop findById(Long id);
    void save(Lop lop);
    void remove(Long id);

    Page<Lop> findAllByGiaovien(Pageable pageable, Giaovien giaovien);
    Iterable<Lop> findAllByGiaovien(Giaovien giaovien);
    Iterable<Lop> findAllByMonhoc(Monhoc monhoc);
    Page<Lop> findAllByMonhoc(Pageable pageable, Monhoc monhoc);

}
