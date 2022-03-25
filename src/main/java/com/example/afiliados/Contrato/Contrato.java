package com.example.afiliados.Contrato;

import com.example.afiliados.Afiliado.Afiliado;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Contrato {
    @Id
    @GeneratedValue
    private Long id;
    private Integer cantidadUsuarios;
    private LocalDate fechaInicio;
    private LocalDate fechaRegistro;
    private LocalDate fechaRetiro;
    private String eps;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "afiliado")
    private Afiliado afiliado;

    public Contrato() {
    }

    public Contrato(Integer cantidadUsuarios, LocalDate fechaInicio, LocalDate fechaRegistro, LocalDate fechaRetiro, String eps, Afiliado afiliado) {
        this.cantidadUsuarios = cantidadUsuarios;
        this.fechaInicio = fechaInicio;
        this.fechaRegistro = fechaRegistro;
        this.fechaRetiro = fechaRetiro;
        this.eps = eps;
        this.afiliado = afiliado;
    }

    public Contrato(Long id, Integer cantidadUsuarios, LocalDate fechaInicio, LocalDate fechaRegistro, LocalDate fechaRetiro, String eps, Afiliado afiliado) {
        this.id = id;
        this.cantidadUsuarios = cantidadUsuarios;
        this.fechaInicio = fechaInicio;
        this.fechaRegistro = fechaRegistro;
        this.fechaRetiro = fechaRetiro;
        this.eps = eps;
        this.afiliado = afiliado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidadUsuarios() {
        return cantidadUsuarios;
    }

    public void setCantidadUsuarios(Integer cantidadUsuarios) {
        this.cantidadUsuarios = cantidadUsuarios;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDate fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }
}