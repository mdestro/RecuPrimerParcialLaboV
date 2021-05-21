package com.example.recuprimerparciallabov;

public class AutoModel {

private Integer id;
private String marca;
private String modelo;
private Integer anio;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnio() {
        return anio;
    }

    public AutoModel(Integer id, String marca, String modelo, Integer anio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
}
