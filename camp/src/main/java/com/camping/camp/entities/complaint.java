package com.camping.camp.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
public class complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComplaint;
    private String subject;
    private String description;
    private Date date;

}
