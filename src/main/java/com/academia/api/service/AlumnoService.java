package com.academia.api.service;

import com.academia.api.model.Alumno;
import com.academia.api.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public Alumno crearAlumno(Alumno alumno) {

        if (alumnoRepository.existsByMatricula(alumno.getMatricula())) {
            throw new IllegalArgumentException("Ya existe un alumno con esa matrícula.");
        }

        return alumnoRepository.save(alumno);
    }
}