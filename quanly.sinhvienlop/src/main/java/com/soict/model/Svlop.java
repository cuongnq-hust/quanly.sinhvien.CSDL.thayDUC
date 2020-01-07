package com.soict.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "svlop")
public class Svlop   {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Float diem;



    @ManyToOne
    @JoinColumn(name = "sinhvien_id")

    public Sinhvien sinhvien;

    public Sinhvien getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(Sinhvien sinhvien) {
        this.sinhvien = sinhvien;
    }

    @ManyToOne
    @JoinColumn(name = "lop_id")

    public Lop lop;

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }


    public Svlop() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Float getPrice() {
        return diem;
    }

    public void setPrice(Float diem) {
        this.diem = diem;
    }

}
