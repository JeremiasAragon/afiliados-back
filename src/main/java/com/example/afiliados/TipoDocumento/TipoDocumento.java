package com.example.afiliados.TipoDocumento;

import com.example.afiliados.Afiliado.Afiliado;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TipoDocumento {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Integer estado;

    @JsonBackReference
    @OneToMany(mappedBy = "tipoDocumento")
    private List<Afiliado> afiliados;

    public TipoDocumento() {
    }

    public TipoDocumento(String nombre, Integer estado, List<Afiliado> afiliados) {
        this.nombre = nombre;
        this.estado = estado;
        this.afiliados = afiliados;
    }

    public TipoDocumento(Long id, String nombre, Integer estado, List<Afiliado> afiliados) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.afiliados = afiliados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<Afiliado> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<Afiliado> afiliados) {
        this.afiliados = afiliados;
    }
}