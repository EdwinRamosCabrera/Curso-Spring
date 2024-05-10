package com.cinema.films.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParametrosController {
    @GetMapping(value="/parametros")
    public String parametros(@RequestParam(defaultValue = "default value") String valor, @RequestParam(defaultValue = "", name="valor_dos") String otroValor, Model model){
        model.addAttribute("parametro", valor);
        model.addAttribute("otroValor", otroValor);
        model.addAttribute("title", "Uso de Parámetros");
        return "parametros";
    }
}
