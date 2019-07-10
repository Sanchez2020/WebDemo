package com.lei.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

/**
 * 产品实体类
 * @author Chris
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Integer id;         //产品id

    @Column(name = "product_name", unique = true)
    private String name;        //产品名称

    @Column(length = 10, precision = 10, scale = 2)
    private Double price;   //价格

    private String material;    //材料

    private Integer style;      //款式，0表示只有男款，1表示只有女款，2表示男女款都有

    private String note;        //备注

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Colour> colours;  //一款产品有多种颜色

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Size> sizes;  //一款产品有多个号码（表示大小）

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;  //多个产品同属一个类别

    public Product() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Colour> getColours() {
        return colours;
    }

    public void setColours(List<Colour> colours) {
        this.colours = colours;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public Category getCategory() {
        return category;
    }

    @JsonBackReference
    public void setCategory(Category category) {
        this.category = category;
    }
}
