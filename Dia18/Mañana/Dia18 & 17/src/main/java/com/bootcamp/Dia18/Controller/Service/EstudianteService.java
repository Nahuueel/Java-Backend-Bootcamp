package com.bootcamp.Dia18.Controller.Service;

import java.util.List;

import com.bootcamp.Dia18.Controller.Respository.EstudianteRepository;
import com.bootcamp.Dia18.Model.Estudiante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository er;

    public List<Estudiante> getAllEstudiantes() {
        List<Estudiante> estudiantes = er.findAll();
        return estudiantes;
    }

    public Estudiante getEstudianteByID(Long id) {
        return er.getEstudianteById(id);
    }
    
    public void registerEstudiante(Estudiante estudiante) {
        er.save(estudiante);
    }

    public void modifyEstudiante(Estudiante estudiante, String dni) {
        estudiante.setDni(dni);
        er.save(estudiante);
    }

    public void deleteEstudiante(long id) {
        er.deleteById(id);
    }
}
