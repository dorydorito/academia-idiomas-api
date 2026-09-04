package com.academia.api.graphql;

import com.academia.api.model.Alumno;
import com.academia.api.service.AlumnoService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AlumnoGraphQLController {

    private final AlumnoService alumnoService;

    public AlumnoGraphQLController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @QueryMapping
    public List<Alumno> alumnos(
            @Argument String matricula,
            @Argument String nombre,
            @Argument String correo,
            @Argument String idiomaNativo,
            @Argument Integer nivel) {

        return alumnoService.buscarAlumnos(
                matricula,
                nombre,
                correo,
                idiomaNativo,
                nivel
        );
    }
}