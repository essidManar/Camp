package com.camping.camp.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategory", updatable = false, nullable = false)
    private Long  idCategory;
    private String name;

}
