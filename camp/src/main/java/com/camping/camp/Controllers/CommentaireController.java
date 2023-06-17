package com.camping.camp.Controllers;

import com.camping.camp.dto.CommentaireDto;
import com.camping.camp.dto.PublicationDto;
import com.camping.camp.services.Impl.CommentaireServiceImp;
import com.camping.camp.services.Impl.PublicationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/com/")
public class CommentaireController {
    @Autowired
    private CommentaireServiceImp commentaireServiceImp ;

    @PostMapping("/{id}")
    public ResponseEntity createComment(@RequestBody CommentaireDto comDto,@PathVariable("id")Long idPub) {
        commentaireServiceImp.createCom(comDto,idPub);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CommentaireDto>> showAllComments() {
        return new ResponseEntity<>(commentaireServiceImp.showAllComs(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CommentaireDto> getSingleComment(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(commentaireServiceImp.readSingleCom(id), HttpStatus.OK);
    }
    @PutMapping("/{id}/like")
    public ResponseEntity<CommentaireDto> like (@PathVariable Long id) {
        commentaireServiceImp.likeComment(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{id}/dislike")
    public ResponseEntity<CommentaireDto> dislike (@PathVariable Long id) {
        commentaireServiceImp.dislikeComment(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
