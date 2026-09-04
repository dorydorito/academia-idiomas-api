package com.academia.api.repository;

import com.academia.api.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    boolean existsByMatricula(String matricula);
}