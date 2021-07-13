package com.example.tareamapa;

public class ListAdapter {
    String facultad;
    String decano;
    Double coorX, coorY;
    String img;

    public ListAdapter(String facultad, String decano, Double coorX, Double coorY, String img) {
        this.facultad = facultad;
        this.decano = decano;
        this.coorX = coorX;
        this.coorY = coorY;
        this.img = img;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getDecano() {
        return decano;
    }

    public void setDecano(String decano) {
        this.decano = decano;
    }

    public Double getCoorX() {
        return coorX;
    }

    public void setCoorX(Double coorX) {
        this.coorX = coorX;
    }

    public Double getCoorY() {
        return coorY;
    }

    public void setCoorY(Double coorY) {
        this.coorY = coorY;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
