package com.camping.camp.services.Impl;

import com.camping.camp.dto.PublicationDto;
import com.camping.camp.dto.TitleDto;
import com.camping.camp.entities.Publication;
import com.camping.camp.entities.User;
import com.camping.camp.repositories.PublicationRepository;
import com.camping.camp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;
@Service
public class PublicationServiceImp {

    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private UserRepository userRepository;

    public List<PublicationDto> showAllPubs() {
        List<Publication> posts = publicationRepository.findAll();
        return posts.stream().map(this::mapFromPubToDto).collect(toList());
    }
    public List<TitleDto> showAllTitle() {
        List<Publication> posts = publicationRepository.findAll();
        return posts.stream().map(this::mapFromPubToTitle).collect(toList());
    }

    public void createPub(PublicationDto pubDto,Long userID) {
        User user=userRepository.findById(userID).orElse(null);
        Publication pub = mapFromDtoToPub(pubDto);
        pub.setUser(user);
        publicationRepository.save(pub);
    }

    public PublicationDto readSinglePub(Long id) {
        Publication pub = publicationRepository.findById(id).orElseThrow();
        return mapFromPubToDto(pub);
    }


    public boolean compareTitles(TitleDto existingTitle, PublicationDto pubDto, double minMatchingPercentage) {
        int minLength = Math.min(existingTitle.getTitre().length(), pubDto.getTitre().length());
        int matchingLength = 0;

        for (int i = 0; i < minLength; i++) {
            if (existingTitle.getTitre().charAt(i) == pubDto.getTitre().charAt(i)) {
                matchingLength++;
            }
        }

        double similarityPercentage = (double) matchingLength / minLength * 100;
        return similarityPercentage >= minMatchingPercentage;
    }


    private PublicationDto mapFromPubToDto(Publication publication) {
        PublicationDto pubDto = new PublicationDto();
        pubDto.setIdPub(publication.getIdPub());
        pubDto.setTitre(publication.getTitre());
        pubDto.setDescription(publication.getDescription());
        return pubDto;
    }
    private TitleDto mapFromPubToTitle(Publication publication) {
        TitleDto titleDto = new TitleDto();
        titleDto.setTitre(publication.getTitre());
        return titleDto;
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
