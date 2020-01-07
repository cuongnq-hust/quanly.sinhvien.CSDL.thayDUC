package com.soict.repository;

import com.soict.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SvlopRepository extends PagingAndSortingRepository<Svlop,Long> {
    Iterable<Svlop> findAllBySinhvien(Sinhvien sinhvien);
    Iterable<Svlop> findAllByLop(Lop lop);

    Page<Svlop> findAllByLop(Pageable pageable, Lop lop);
    Page<Svlop> findAllBySinhvien(Pageable pageable, Sinhvien sinhvien);



//    Page<Svlop> findAllByNameContaining(String name, Pageable pageable);
//    Page<Svlop> findAllByOrderByPriceAsc(Pageable pageable);
//    Page<Svlop> findAllByOrderByPriceDesc(Pageable pageable);
//    Page<Svlop> findAllByOrderByDateOfPurchase(Pageable pageable);

}
