package com.soict.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "giaoviens")
public class Giaovien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String maGV;
    private String tenGV;
    private String hoGV;
    private String donVi;
    public List<Lop> getCustomers() {
        return lops;
    }
    public void setCustomers(List<Lop> lops) {
        this.lops = lops;
    }

    @OneToMany(targetEntity = Lop.class)
    private List<Lop> lops;

    public Giaovien() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getHoGV() {
        return hoGV;
    }

    public void setHoGV(String hoGV) {
        this.hoGV = hoGV;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }
}
