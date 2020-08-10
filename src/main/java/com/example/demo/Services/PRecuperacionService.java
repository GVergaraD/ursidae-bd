package com.example.demo.Services;

import com.example.demo.Models.PRecuperacion;
import com.example.demo.Repository.PRecuperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("ServicioPRecuperacion")
public class PRecuperacionService {

	@Autowired
	@Qualifier("RepositoryPRecuperacion")
	private PRecuperacionRepository precuperacionRepository;


	//request
	public List<PRecuperacion> listAll() {
		return (precuperacionRepository.findAll());
	}
	public Optional<PRecuperacion> listOne(Long id) {
		return (precuperacionRepository.findById(id));
	}
	public List<PRecuperacion> listByCargo(String cargo) {
		return (precuperacionRepository.findByCargo(cargo));
	}

	//create & update
	public PRecuperacion saveOrUpdatePRecuperacion(PRecuperacion precuperacion) {
		return precuperacionRepository.save(precuperacion);
	}


	//delete 1 personal por su id
	@Transactional
	public void deletePaciente(Long id) {
		precuperacionRepository.deleteById(id);
	}
}
