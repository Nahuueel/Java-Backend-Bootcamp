package com.bootcamp.Dia18PairProgramming.Service.Controller;

import com.bootcamp.Dia18PairProgramming.Model.Unidad;
import com.bootcamp.Dia18PairProgramming.Service.UnidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UnidadController {
    @Autowired
    UnidadesService service;
    @GetMapping
    public String getAllUnidad(Model model) {
        model.addAttribute("unidades", service.getAllUnidades());
        return "index";
    }

    @GetMapping("/create")
    public String showForUnidad(Model model) {
        Unidad unidad = new Unidad();
        model.addAttribute("unidad", unidad);
        return "createUnidad";
    }

    @PostMapping("/create")
    public String saveUnidad(@ModelAttribute("unidad") Unidad unidad) {

       service.registrarUnidad(unidad);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUnidad(@PathVariable("id") String id, Model model) {
        Unidad unidad = service.getUnidadesByID(id);
        model.addAttribute("unidad", unidad);
        return "update_unidad";
    }

    @PostMapping("/update/{id}")
    public String updateUnidad(@ModelAttribute("unidad") Unidad unidad, @PathVariable("id") String id) {
        //unidad.setId(id);
        service.registrarUnidad(unidad);
        return "redirect:/";
    }
}
