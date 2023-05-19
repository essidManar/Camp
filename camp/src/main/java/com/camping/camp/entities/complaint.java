package com.camping.camp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcomplaint", updatable = false, nullable = false)
    private Long idComplaint;
    private String subject;
    private String description;
    private Date date;

}
