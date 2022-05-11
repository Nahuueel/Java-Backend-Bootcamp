package com.bootcamp.Dia18.Controller;

import com.bootcamp.Dia18.Controller.Service.EstudianteService;
import com.bootcamp.Dia18.Model.Estudiante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    EstudianteService es;

    @GetMapping
    public String getAllEstudiantes(Model model) {
        model.addAttribute("estudiantes", es.getAllEstudiantes());
        return "EstudianteTemplates/EstudianteIndex";
    }

    @GetMapping("/create")
    public String showFormEstudiantes(Model model) {
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante",estudiante);
        return "EstudianteTemplates/EstudianteCreate";
    }

    @PostMapping("/create")
    public String registerEstudiante(@Validated @ModelAttribute("estudiante") Estudiante estudiante) {
        es.registerEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/update/{id}")
    public String GetsEstudianteToModify(@PathVariable("id") Long id, Model model) {
        Estudiante estudiante = es.getEstudianteByID(id);
        model.addAttribute("estudiante", estudiante);
        return "EstudianteTemplates/EstudianteEdit";
    }

    @PostMapping("/update")
    public String modifyEstudiante(@Validated @ModelAttribute("estudiante") Estudiante estudiante) {
        es.registerEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/delete/{id}")
    public String deleteEstudiante(@PathVariable("id") Long id){
       es.deleteEstudiante(id);
       return "redirect:/estudiantes";
    }
    /*
    @GetMapping("/find/{id}")
    public String getEstudianteByDni(@RequestParam("id") long id, Model model) {
        model.addAttribute("estudiantes",es.getEstudianteById(id));
        return "EstudianteTemplates/EstudianteIndex";
    }
*/
}
