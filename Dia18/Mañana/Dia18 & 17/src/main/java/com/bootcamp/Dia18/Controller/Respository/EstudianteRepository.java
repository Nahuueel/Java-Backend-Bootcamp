package com.bootcamp.Dia18.Controller.Respository;

import com.bootcamp.Dia18.Model.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
    Estudiante getEstudianteById(Long id);
}
