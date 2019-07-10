package com.lei.demo.domain;

import javax.persistence.*;
import java.util.List;

/**
 * 商品类别实体类
 * @author Chris
 */
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Integer id;     //类别id

    @Column(unique = true)
    private String type;    //型号

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private List<Product> products;  //一个类别有多个产品

    public Category() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
