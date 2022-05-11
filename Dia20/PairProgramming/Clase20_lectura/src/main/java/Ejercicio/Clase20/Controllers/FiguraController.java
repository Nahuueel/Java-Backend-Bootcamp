package Ejercicio.Clase20.Controllers;

import Ejercicio.Clase20.Controllers.Service.FiguraService;
import Ejercicio.Clase20.Models.Figura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;

@Controller
@RequestMapping("/figuras")
public class FiguraController {
    @Autowired
    FiguraService fs;

    @GetMapping
    public String getFiguras(Model model){
        model.addAttribute("figuras", fs.getAllFiguras());
        return "FigurasIndex";
    }
    @GetMapping("/comprar/{id}")
    public String Buy(RedirectAttributes model, @PathVariable("id") long id){
        Figura figura=fs.findById(id);
        String mensaje= "Se ha comprado el producto "+figura.getNombre()+ " con el id "+figura.getId()+" a un valor " +
                "de $"+figura.getPrecio()+". Fecha de adquisición: "+new Date(System.currentTimeMillis());
                model.addFlashAttribute("mensaje", mensaje)
                .addFlashAttribute("clase", "success");
        return "redirect:/figuras";
    }
}
