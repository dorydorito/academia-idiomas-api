package com.academia.api.controller;

import com.academia.api.model.Alumno;
import com.academia.api.service.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @PostMapping
    public ResponseEntity<?> crearAlumno(@Valid @RequestBody Alumno alumno) {

        try {
            Alumno alumnoCreado = alumnoService.crearAlumno(alumno);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(alumnoCreado);

        } catch (IllegalArgumentException e) {

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
}