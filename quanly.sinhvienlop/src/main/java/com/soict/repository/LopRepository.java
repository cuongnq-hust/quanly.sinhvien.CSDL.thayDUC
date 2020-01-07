package com.soict.repository;

import com.soict.model.Monhoc;
import com.soict.model.Giaovien;
import com.soict.model.Lop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LopRepository extends PagingAndSortingRepository<Lop,Long> {
    Iterable<Lop> findAllByGiaovien(Giaovien giaovien);
    Page<Lop> findAllByGiaovien(Pageable pageable, Giaovien giaovien);

    Iterable<Lop> findAllByMonhoc(Monhoc monhoc);
    Page<Lop> findAllByMonhoc(Pageable pageable, Monhoc monhoc);

}
