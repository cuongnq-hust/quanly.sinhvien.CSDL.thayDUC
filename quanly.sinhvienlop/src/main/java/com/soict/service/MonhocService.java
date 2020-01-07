package com.soict.service;

import com.soict.model.Monhoc;

public interface MonhocService {
    Iterable<Monhoc> findAll();
    Monhoc findById(Long id);
    void save(Monhoc monhoc);
    void remove(Long id);
}
