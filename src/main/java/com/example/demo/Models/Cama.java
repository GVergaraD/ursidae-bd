package com.example.demo.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "camas")
public class Cama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(mappedBy = "camas")
    //private Set<PRecuperacion> precuperacions;

    @Column(name = "estado")
    private String estado;

    @Column(name = "nombre_paciente")
    private String nombre;

    @Column(name = "nombre_paciente")
    private Integer sala;

    public Long getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }
}
