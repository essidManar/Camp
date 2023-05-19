package com.camping.camp.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String name;
    private String lastName;
    private String email;
    private String password;
    private Date inscription_date;
    private String address;
    private String phone_number;


}
