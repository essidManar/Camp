package com.camping.camp.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class campCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCampCenter;

    private String name;
    private String address;
    private String phone;
    private String webSite;
    private int capacity;
    private float cost;

}
