package com.camping.camp.repositories;

import com.camping.camp.entities.Commentaire;
import com.camping.camp.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}
