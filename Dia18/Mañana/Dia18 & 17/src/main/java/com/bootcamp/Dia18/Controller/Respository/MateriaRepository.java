package com.bootcamp.Dia18.Controller.Respository;

import com.bootcamp.Dia18.Model.Materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia,String> {
    Materia getMateriaByCodMat(String codMat);
}
