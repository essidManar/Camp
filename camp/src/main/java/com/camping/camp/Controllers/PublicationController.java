package com.camping.camp.Controllers;

import com.camping.camp.dto.PublicationDto;
import com.camping.camp.services.Impl.PublicationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/")
public class PublicationController {



@Autowired
    private PublicationServiceImp publicationServiceImp ;

    @PostMapping
    public ResponseEntity createPub(@RequestBody PublicationDto  pubDto) {
        publicationServiceImp.createPub(pubDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PublicationDto>> showAllPubs() {
        return new ResponseEntity<>(publicationServiceImp.showAllPubs(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PublicationDto> getSinglePub(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(publicationServiceImp.readSinglePub(id), HttpStatus.OK);
    }

}
