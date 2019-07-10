package com.lei.demo.domain;

import javax.persistence.*;

/**
 * 颜色字典表
 * @author Chris
 */
@Entity
@Table(name = "colour")
public class Colour {

    @Id
    @GeneratedValue
    @Column(name = "colour_id")
    private Integer id;         //颜色id

    @Column(unique = true)
    private String colour;      //颜色描述

    public Colour() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
