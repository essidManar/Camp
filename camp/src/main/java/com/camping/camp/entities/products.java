package com.camping.camp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct", updatable = false, nullable = false)
    private Long idProduct;
    private String name;
    private String description;
    private String image;
    private float price;
    private int quantity;

}
