package com.soict.service;

import com.soict.model.Giaovien;

public interface GiaovienService {
    Iterable<Giaovien> findAll();
    Giaovien findById(Long id);
    void save(Giaovien giaovien);
    void remove(Long id);

}
