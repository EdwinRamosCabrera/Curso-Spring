package com.cinema.films.models;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String Nombre;
    private List<Jugador> plantilla;

    public Equipo() {
        plantilla = new ArrayList<>();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public List<Jugador> getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(List<Jugador> plantilla) {
        this.plantilla = plantilla;
    }

    public void addJugador(Jugador jugador){
        plantilla.add(jugador);
    }
}
