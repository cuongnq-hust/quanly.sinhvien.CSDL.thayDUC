package com.soict.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lops")
public class Lop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String maLop;
    private String namHoc;
    private String hocKy;

    public List<Svlop> getCustomers() {
        return svlops;
    }

    public void setCustomers(List<Svlop> svlops) {
        this.svlops = svlops;
    }

    @OneToMany(targetEntity = Svlop.class)
    private List<Svlop> svlops;

    @ManyToOne
    @JoinColumn(name = "monhoc_id")

    public Monhoc monhoc;

    public Monhoc getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
    }

    @ManyToOne
    @JoinColumn(name = "giaovien_id")

    public Giaovien giaovien;

    public Giaovien getGiaovien() {
        return giaovien;
    }

    public void setGiaovien(Giaovien giaovien) {
        this.giaovien = giaovien;
    }

    public Lop() {
    }

    public Lop(String maLop, String namHoc, String hocKy, Monhoc monhoc, Giaovien giaovien) {
        this.maLop = maLop;
        this.namHoc = namHoc;
        this.hocKy = hocKy;
        this.monhoc = monhoc;
        this.giaovien = giaovien;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }
}
