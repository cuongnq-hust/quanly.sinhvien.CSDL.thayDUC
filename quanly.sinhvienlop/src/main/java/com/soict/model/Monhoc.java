package com.soict.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "monhocs")
public class Monhoc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String maMH;
    private String tenMH;
    private Double soTC;

//    private String name;
//    private String description;

//    public List<Book> getCustomers() {
//        return books;
//    }
//
//    public void setCustomers(List<Book> books) {
//        this.books = books;
//    }
//
//    @OneToMany(targetEntity = Book.class)
//    private List<Book> books;

    public Monhoc() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public Double getSoTC() {
        return soTC;
    }

    public void setSoTC(Double soTC) {
        this.soTC = soTC;
    }

}
