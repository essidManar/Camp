package com.camping.camp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class campCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdcampCenter", updatable = false, nullable = false)
    private Long IdCampCenter;

    private String name;
    private String address;
    private String phone;
    private String webSite;
    private int capacity;
    private float cost;

}
