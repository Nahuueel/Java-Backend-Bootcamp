package com.bootcamp.Dia18.Controller.Service;

import java.util.ArrayList;

import com.bootcamp.Dia18.Controller.Respository.MateriaRepository;
import com.bootcamp.Dia18.Model.Materia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaService {
    @Autowired
    MateriaRepository mr;

    public ArrayList<Materia> getAllMaterias() {
        return (ArrayList<Materia>) mr.findAll();
    }

    public Materia getMateriaByCod(String codMat) {
        return mr.getMateriaByCodMat(codMat);
    }

    public void registerMateria(Materia materia) {
        mr.save(materia);
    }

    public void modifyMateria(Materia materia, String codMat) {
        materia.setCodMat(codMat);
        mr.save(materia);
    }

    public void deleteMateria(String codMateria) {
        mr.deleteById(codMateria);
    }

}
