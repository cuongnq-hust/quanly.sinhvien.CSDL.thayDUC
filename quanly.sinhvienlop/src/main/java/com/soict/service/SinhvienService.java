package com.soict.service;

import com.soict.model.Sinhvien;

public interface SinhvienService {


    Iterable<Sinhvien> findAll();
    Sinhvien findById(Long id);
    void save(Sinhvien sinhvien);
    void remove(Long id);

}
