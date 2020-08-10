package com.example.demo.Services;


import com.example.demo.Models.Paciente;
import com.example.demo.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("ServicioPaciente")
public class PacienteService {

    @Autowired
    @Qualifier("RepositoryPaciente")
    private PacienteRepository pacienteRepository;


    //request
    public List<Paciente> listAll(){
        return (pacienteRepository.findAll());
    }
    public Optional<Paciente> listOne(Long id) {
        return (pacienteRepository.findById(id));
    }
    public List<Paciente> listByTipo(String tipo){
        return (pacienteRepository.findByTipo(tipo));
    }

    //create & update
    public Paciente saveOrUpdatePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente findbyNombre(String name){
        return pacienteRepository.findByNombre(name);

    }
    //public Paciente getPaciente(Long id){
    //    return pacienteRepository.findById(id);

    //}

    //delete 1 paciente por su id
    @Transactional
    public void deletePaciente(Long id){
        pacienteRepository.deleteById(id);
    }

}
