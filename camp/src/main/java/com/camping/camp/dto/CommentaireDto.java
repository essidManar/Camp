package com.camping.camp.dto;


public class CommentaireDto {
    private Long idCom;
    private String content;


    private int likes;
    private int dislikes;

    public Long getIdCom() {
        return idCom;
    }

    public void setIdCom(Long idCom) {
        this.idCom = idCom;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
}
