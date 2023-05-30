package com.camping.camp.services.Impl;

import com.camping.camp.dto.PublicationDto;
import com.camping.camp.entities.Publication;
import com.camping.camp.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;
@Service
public class PublicationServiceImp {

    @Autowired
    private PublicationRepository publicationRepository;

    public List<PublicationDto> showAllPubs() {
        List<Publication> posts = publicationRepository.findAll();
        return posts.stream().map(this::mapFromPubToDto).collect(toList());
    }

    public void createPub(PublicationDto pubDto) {
        Publication pub = mapFromDtoToPub(pubDto);
        publicationRepository.save(pub);
    }

    public PublicationDto readSinglePub(Long id) {
        Publication pub = publicationRepository.findById(id).orElseThrow();
        return mapFromPubToDto(pub);
    }

    private PublicationDto mapFromPubToDto(Publication publication) {
        PublicationDto pubDto = new PublicationDto();
        pubDto.setIdPub(publication.getIdPub());
        pubDto.setTitre(publication.getTitre());
        pubDto.setDescription(publication.getDescription());
        return pubDto;
    }

    private Publication mapFromDtoToPub(PublicationDto publicDto) {
        Publication pub = new Publication();
        pub.setIdPub(publicDto.getIdPub());
        pub.setTitre(publicDto.getTitre());
        pub.setDescription(publicDto.getDescription());
        //User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        pub.setDate_creation(Instant.now());
        //pub.setUsername(loggedInUser.getUsername());
        pub.setDate_modif(Instant.now());
        return pub;
    }





}
