package com.lei.demo.domain;

import javax.persistence.*;

/**
 * @author Chris
 */
@Entity
@Table(name = "shoes")
public class Shoes {

    @Id
    @GeneratedValue
    @Column(name = "shoes_id")
    private Integer id;         //id

    private Integer stock;      //库存

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;    //所属产品

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "colour_id")
    private Colour colour;      //颜色

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "size_id")
    private Size size;          //大小

    //@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "style")
    private Integer style;      //款式

    public Shoes() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "id=" + id +
                ", stock=" + stock +
                ", product=" + product +
                ", colour=" + colour +
                ", size=" + size +
                ", style=" + style +
                '}';
    }
}
