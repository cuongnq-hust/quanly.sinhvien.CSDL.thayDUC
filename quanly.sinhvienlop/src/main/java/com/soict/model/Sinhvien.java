package com.soict.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "sinhviens")
public class Sinhvien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String maSV;
    private String tenSV;
    private String hoSV;
    private Date ngaySinh;
    private String noiSinh;

    public List<Svlop> getCustomers() {
        return svlops;
    }
    public void setCustomers(List<Svlop> svlops) {
        this.svlops = svlops;
    }

    @OneToMany(targetEntity = Svlop.class)
    private List<Svlop> svlops;

    public Sinhvien() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getHoSV() {
        return hoSV;
    }

    public void setHoSV(String hoSV) {
        this.hoSV = hoSV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }
}
