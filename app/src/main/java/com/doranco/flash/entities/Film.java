package com.doranco.flash.entities;

public class Film
{
    private int id;
    private String titre;
    private String image;

    public Film() {
    }

    public Film(int id, String titre, String image) {
        this.id = id;
        this.titre = titre;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
