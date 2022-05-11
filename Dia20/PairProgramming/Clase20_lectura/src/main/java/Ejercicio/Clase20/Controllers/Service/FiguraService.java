package Ejercicio.Clase20.Controllers.Service;

import Ejercicio.Clase20.Controllers.Repository.FiguraRepository;
import Ejercicio.Clase20.Models.Figura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FiguraService {
    @Autowired
    FiguraRepository fr;
    public ArrayList<Figura> getAllFiguras() { return (ArrayList<Figura>) fr.findAll(); }
    public Figura findById(long id) { return fr.findById(id); }
}
