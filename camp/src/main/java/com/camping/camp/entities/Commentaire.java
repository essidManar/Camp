package com.camping.camp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCom;

    private String content;
    private Instant date_creation;
    private Instant date_modif;
    private int likes;
    private int dislikes;

    @ManyToOne
    @JsonIgnore
    private Publication publication;
    @ManyToOne
    @JsonIgnore
    private User user;

}
