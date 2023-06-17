package com.camping.camp.services.Impl;

import com.camping.camp.dto.CommentaireDto;
import com.camping.camp.dto.PublicationDto;
import com.camping.camp.entities.Commentaire;
import com.camping.camp.entities.Publication;
import com.camping.camp.entities.User;
import com.camping.camp.repositories.CommentaireRepository;
import com.camping.camp.repositories.PublicationRepository;
import com.camping.camp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommentaireServiceImp {
    @Autowired
    private CommentaireRepository commentaireRepository;
    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private UserRepository userRepository;


    public List<CommentaireDto> showAllComs() {
        List<Commentaire> com = commentaireRepository.findAll();
        return com.stream().map(this::mapFromComToDto).collect(toList());
    }

    public void createCom(CommentaireDto comDto,Long idPub,Long userID) {
        User user=userRepository.findById(userID).orElse(null);
        Publication pub=publicationRepository.findById(idPub).orElse(null);
        Commentaire com = mapFromDtoToCom(comDto);
        com.setPublication(pub);
        com.setUser(user);
        commentaireRepository.save(com);
    }
    public CommentaireDto readSingleCom(Long id) {
        Commentaire com = commentaireRepository.findById(id).orElseThrow();
        return mapFromComToDto(com);
    }
    public Commentaire likeComment( Long id) {
        Commentaire com = commentaireRepository.findById(id).orElseThrow();
        if (com != null) {
            com.setLikes(com.getLikes() + 1);
        }

        return  commentaireRepository.save(com);
    }


    public Commentaire dislikeComment(Long id) {
        Commentaire com = commentaireRepository.findById(id).orElseThrow();
        if (com != null) {
            com.setDislikes(com.getDislikes() + 1);
        }
        return commentaireRepository.save(com);
    }

    private CommentaireDto mapFromComToDto(Commentaire commentaire) {
        CommentaireDto comDto = new CommentaireDto();
        comDto.setIdCom(commentaire.getIdCom());
        comDto.setContent(commentaire.getContent());
        return comDto;
    }

    private Commentaire mapFromDtoToCom(CommentaireDto commentDto) {
        Commentaire com = new Commentaire();
        com.setIdCom(commentDto.getIdCom());
        com.setContent(commentDto.getContent());
        //User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        com.setDate_creation(Instant.now());
        //pub.setUsername(loggedInUser.getUsername());
        com.setDate_modif(Instant.now());
        com.setLikes(com.getLikes());
        com.setDislikes(commentDto.getDislikes());
        return com;
    }
}
