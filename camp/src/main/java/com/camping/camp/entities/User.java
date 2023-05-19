package com.camping.camp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", updatable = false, nullable = false)
    private Long userID;

    private String name;
    private String lastName;
    private String email;
    private String password;
    private Date inscription_date;
    private String address;
    private String phone_number;


}
