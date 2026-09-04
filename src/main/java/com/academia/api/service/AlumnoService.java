package com.academia.api.service;

import com.academia.api.model.Alumno;
import com.academia.api.repository.AlumnoRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Alumno> buscarAlumnos(
            String matricula,
            String nombre,
            String correo,
            String idiomaNativo,
            Integer nivel) {

        Specification<Alumno> specification =
                (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();

        if (matricula != null && !matricula.isBlank()) {
            specification = specification.and(
                    (root, query, criteriaBuilder) ->
                            criteriaBuilder.equal(root.get("matricula"), matricula)
            );
        }

        if (nombre != null && !nombre.isBlank()) {
            specification = specification.and(
                    (root, query, criteriaBuilder) ->
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("nombre")),
                                    "%" + nombre.toLowerCase() + "%"
                            )
            );
        }

        if (correo != null && !correo.isBlank()) {
            specification = specification.and(
                    (root, query, criteriaBuilder) ->
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("correo")),
                                    "%" + correo.toLowerCase() + "%"
                            )
            );
        }

        if (idiomaNativo != null && !idiomaNativo.isBlank()) {
            specification = specification.and(
                    (root, query, criteriaBuilder) ->
                            criteriaBuilder.equal(
                                    criteriaBuilder.lower(root.get("idiomaNativo")),
                                    idiomaNativo.toLowerCase()
                            )
            );
        }

        if (nivel != null) {
            specification = specification.and(
                    (root, query, criteriaBuilder) ->
                            criteriaBuilder.equal(root.get("nivel"), nivel)
            );
        }

        return alumnoRepository.findAll(specification);
    }
}