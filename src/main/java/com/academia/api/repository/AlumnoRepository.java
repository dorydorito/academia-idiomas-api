package com.academia.api.repository;

import com.academia.api.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlumnoRepository
        extends JpaRepository<Alumno, Long>,
                JpaSpecificationExecutor<Alumno> {

    boolean existsByMatricula(String matricula);
}