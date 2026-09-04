package com.academia.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String matricula;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String apellidoPaterno;

    private String apellidoMaterno;

    @NotBlank
    @Email
    @Column(nullable = false)
    private String correo;

    private String telefono;

    @NotBlank
    @Column(nullable = false)
    private String idiomaNativo;

    private Integer nivel;

    private String recomendadoPor;

    @NotNull
    @Column(nullable = false)
    private Boolean tieneFamiliar;

    private String matriculaFamiliar;

    public Alumno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdiomaNativo() {
        return idiomaNativo;
    }

    public void setIdiomaNativo(String idiomaNativo) {
        this.idiomaNativo = idiomaNativo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getRecomendadoPor() {
        return recomendadoPor;
    }

    public void setRecomendadoPor(String recomendadoPor) {
        this.recomendadoPor = recomendadoPor;
    }

    public Boolean getTieneFamiliar() {
        return tieneFamiliar;
    }

    public void setTieneFamiliar(Boolean tieneFamiliar) {
        this.tieneFamiliar = tieneFamiliar;
    }

    public String getMatriculaFamiliar() {
        return matriculaFamiliar;
    }

    public void setMatriculaFamiliar(String matriculaFamiliar) {
        this.matriculaFamiliar = matriculaFamiliar;
    }
}