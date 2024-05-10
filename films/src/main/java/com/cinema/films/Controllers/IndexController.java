package com.cinema.films.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("titulo", "Soy el titulo");
        model.addAttribute("saludo", "Hola a todos de código facilito");
        model.addAttribute("show", false);
        List<String> series = null; // List.of("Dexter", "Game of Thrones", "Vikings");
        model.addAttribute("series", series);
        return "index";
    }
    @GetMapping(value="/index-mv")
    public ModelAndView indexMV(ModelAndView mv){
        mv.addObject("titulo", "Titulo de MV");
        mv.addObject("saludo", "Saludo de MV");
        mv.addObject("show", true);
        //List<String> series = List.of("Dexter", "Game of Thrones", "Vikings");
        //mv.addObject("series", series);
        mv.setViewName("index");
        return  mv;
    }
    @ModelAttribute("series")
    public List<String> getSeries(){
        return List.of("Dexter", "Game of thrones", "Vikings", "Flash", "The Last of Us");
    }
    @RequestMapping(value="/index-req-mapping", method = RequestMethod.GET)
    public String indexRequestMapping(){
        return "index";
    }

}
