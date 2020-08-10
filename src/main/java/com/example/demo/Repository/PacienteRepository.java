package com.example.demo.Repository;


import com.example.demo.Models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

//esto implementa las operaciones CRUD para ser usadas
@Repository("RepositoryPaciente")
public interface PacienteRepository extends CrudRepository<Paciente, Long>{
    //Paciente findById(Long id);
    Paciente findByNombre(String nombre);
    //List<Paciente> findByNombre(String nombre);
    public abstract List<Paciente> findAll();

    public abstract List<Paciente> findByTipo(String tipo);//Para filtrar por tipo

    public abstract void deleteById(Long id);




}
