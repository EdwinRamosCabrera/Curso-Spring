package com.cinema.films.Controllers;
import com.cinema.films.Services.EquipoServices;
import com.cinema.films.Services.IService;
import com.cinema.films.models.Equipo;

import com.cinema.films.models.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@Controller
public class ParametrosController {
    private IService equipoService;

    public ParametrosController(@Qualifier("equipoEspaña") IService equipoService){
        this.equipoService = equipoService;
    }
    @GetMapping(value="/parametros")
    public String parametros(@RequestParam(defaultValue = "default value") String valor, @RequestParam(defaultValue = "", name="valor_dos") String otroValor, Model model){
        model.addAttribute("parametro", valor);
        model.addAttribute("otroValor", otroValor);
        model.addAttribute("title", "Uso de Parámetros");
        return "parametros";
    }

    // equipos / {nombre_equipo} / {numero_jugador}
    // equipos/Barcelona/9
    // => Lewandoski (9)
    @GetMapping(value="/equipos/{nombre}/{numero}")
    public String paramtrosPorPath(@PathVariable String nombre, @PathVariable("numero") Integer numero, Model model){  //como es integer se especifica el nombre de la variable
        Optional<Equipo> equipoOptional = equipoService.getTodos().stream().filter(equipo -> nombre.toLowerCase().equals(equipo.getNombre().toLowerCase())).findFirst();
        if(equipoOptional.isPresent()){
            Optional<Jugador> jugadorOptional = equipoOptional.get().getPlantilla().stream().filter(jugador -> numero == jugador.getNumero()).findFirst();
            if (jugadorOptional.isPresent()){
                model.addAttribute("jugador", jugadorOptional.get());
            }
        }
        return "parametros";
    }
    /*
    public List<Equipo> getEquipos(){
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
    */
}
