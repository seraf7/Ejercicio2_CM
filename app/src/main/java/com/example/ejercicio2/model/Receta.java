package com.example.ejercicio2.model;

import java.io.Serializable;

public class Receta implements Serializable {

    private static long indice = 0L;

    private long id;
    private String nombre;
    private String tiempo;
    private int porcion;
    private int tipo;
    private int dificultad;

    public Receta(String nombre, String tiempo, int porcion, int tipo, int dificultad) {
        this.id = Receta.getIndice();
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.porcion = porcion;
        this.tipo = tipo;
        this.dificultad = dificultad;
        //Incrementa el indice de objetos
        Receta.indice++;
    }

    public static long getIndice() {
        return indice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public int getPorcion() {
        return porcion;
    }

    public void setPorcion(int porcion) {
        this.porcion = porcion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
}
