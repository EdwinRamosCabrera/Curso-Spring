package com.cinema.films.Services;

import com.cinema.films.models.Equipo;
import com.cinema.films.models.Jugador;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class EquipoInglaterraService implements IService{
    @Override
    public List<Equipo> getTodos() {
        Equipo manchesterCity = new Equipo();
        manchesterCity.setNombre("Manchester City");
        manchesterCity.addJugador(new Jugador("Garnacho", 10));

        Equipo manchesterUnited = new Equipo();
        manchesterUnited.setNombre("Manchester United");
        manchesterUnited.addJugador(new Jugador("Alvarez", 11));

        return List.of(manchesterUnited, manchesterCity);
    }
}
