package com.bootcamp.Dia18.Controller;

import com.bootcamp.Dia18.Controller.Service.MateriaService;
import com.bootcamp.Dia18.Model.Materia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/materias")
public class MateriaController {
    @Autowired
    MateriaService ms;

    @GetMapping
    public String getAllMaterias(Model model) {
        model.addAttribute("materias", ms.getAllMaterias());
        return "MateriaTemplates/MateriaIndex";
    }

    @GetMapping("/create")
    public String showFormMateria(Model model) {
        Materia materia= new Materia();
        model.addAttribute("materia",materia);
        return "MateriaTemplates/MateriaCreate";
    }

    @PostMapping("/create")
    public String registerMateria(@Validated @ModelAttribute("materia") Materia materia) {
        ms.registerMateria(materia);
        return "redirect:/materias";
    }


    @GetMapping("/update/{codMat}")
    public String modifyMateria(@PathVariable("codMat") String codMat, Model model) {
        Materia materia = ms.getMateriaByCod(codMat);
        model.addAttribute("materia", materia);
        return "MateriaTemplates/MateriaEdit";
    }
    
    @PostMapping("/update/{codMat}")
    public String modifyMateria(@Validated @ModelAttribute("materia") Materia materia,
        @PathVariable("codMat") String codMat) {
        ms.modifyMateria(materia,codMat);
        return "redirect:/materias";
    }

    @GetMapping("/delete/{codMat}")
    public String deleteMateria(@PathVariable("codMat") String codMat){
        ms.deleteMateria(codMat);
        return "redirect:/materias";
    }

    @GetMapping("/find")
    public String getMateriaByCod(@RequestParam("codMat") String codMat, Model model) {
        model.addAttribute("materias",ms.getMateriaByCod(codMat));
        return "MateriaTemplates/MateriaIndex";
    }

}
