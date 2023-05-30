package com.camping.camp.dto;


public class PublicationDto {
    private Long idPub;
    private String titre;
    private String description;

    public Long getIdPub() {
        return idPub;
    }

    public void setIdPub(Long idPub) {
        this.idPub = idPub;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
