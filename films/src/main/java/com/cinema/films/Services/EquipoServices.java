package com.cinema.films.Services;

import com.cinema.films.models.Equipo;
import com.cinema.films.models.Jugador;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("equipoEspaña")
public class EquipoServices implements IService{

    public List<Equipo> getTodos(){
        Equipo barcelona = new Equipo();
        barcelona.setNombre("Barcelona");
        barcelona.addJugador(new Jugador("Shabi Alonso", 10));
        barcelona.addJugador(new Jugador("Ronaldinho Gaucho", 11));
        barcelona.addJugador(new Jugador("Xavi Hernández", 6));
        barcelona.addJugador(new Jugador("Dani Alves", 8));
        barcelona.addJugador(new Jugador("Andrés Iniesta", 20));

        Equipo realMadrid = new Equipo();
        realMadrid.setNombre("Real Madrid");
        realMadrid.addJugador(new Jugador("Zinedine Zidane", 10));
        realMadrid.addJugador(new Jugador("Iker Casillas", 12));
        realMadrid.addJugador(new Jugador("Sergio Ramos", 5));
        realMadrid.addJugador(new Jugador("Ronaldo Nazario", 9));
        realMadrid.addJugador(new Jugador("Roberto Carlos", 16));

        return List.of(barcelona, realMadrid);
    }
}
