package com.camping.camp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPub;

    private String titre;
    private String description;
    private Instant date_creation;
    private Instant date_modif;

    @JsonIgnore
    @OneToMany(mappedBy = "publication" , cascade=CascadeType.ALL , fetch = FetchType.EAGER)
    private Set<Commentaire> Commentaires;
    @ManyToOne
    @JsonIgnore
    private User user;

}
