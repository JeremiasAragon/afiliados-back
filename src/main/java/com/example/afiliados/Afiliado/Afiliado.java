package com.example.afiliados.Afiliado;

import com.example.afiliados.Contrato.Contrato;
import com.example.afiliados.TipoDocumento.TipoDocumento;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Afiliado {
    @Id
    @SequenceGenerator(name = "afiliado_sequence", sequenceName = "afiliado_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "afiliado_sequence")
    private Long id;
    private String nombre;
    private String apellidos;
    private String documento;
    private String direccion;
    private String telefono;
    private String mail;
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "tipoDocumento")
    private TipoDocumento tipoDocumento;

    @OneToMany(mappedBy = "afiliado")
    private List<Contrato> contratos;

    public Afiliado() {
    }

    public Afiliado(String nombre, String apellidos, String documento, String direccion, String telefono, String mail, Integer estado, TipoDocumento tipoDocumento, List<Contrato> contratos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.estado = estado;
        this.tipoDocumento = tipoDocumento;
        this.contratos = contratos;
    }

    public Afiliado(Long id, String nombre, String apellidos, String documento, String direccion, String telefono, String mail, Integer estado, TipoDocumento tipo_documento, List<Contrato> contratos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.estado = estado;
        this.tipoDocumento = tipo_documento;
        this.contratos = contratos;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }
}