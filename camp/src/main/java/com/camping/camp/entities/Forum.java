package com.camping.camp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idforum", updatable = false, nullable = false)
    private Long idForum;

    private String titre;
    private String description;
    private Date date_creation;
}
