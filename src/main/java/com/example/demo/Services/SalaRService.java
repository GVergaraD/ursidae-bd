package com.example.demo.Services;


import com.example.demo.Models.SalaR;
import com.example.demo.NotFoundE.SalaNFE;
import com.example.demo.Repository.SalaRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("ServicioSalaR")
public class SalaRService {

	@Autowired
	@Qualifier("RepositorySalaR")
	private SalaRRepository salarRepository;


	//request
	public Iterable<SalaR> listAll() {
		return (salarRepository.findAll());
	}
	public Optional<SalaR> listOne(Long id) {
		return (salarRepository.findById(id));
	}
	public List<SalaR> listByDisponibilidad(int disponibilidad) {
		return (salarRepository.findByDisponibilidad(disponibilidad));
	}

	//create & update
	public SalaR saveOrUpdateSalaR(SalaR salar) {
		return salarRepository.save(salar);
	}


	public SalaR getSala(Long id) {
		return salarRepository.findById(id)
				.orElseThrow(() -> new SalaNFE(id));
	}
	public List<SalaR> getSala(Integer disponibilidad) {
		return salarRepository.findByDisponibilidad(disponibilidad);
	}

	//delete 1 sala por id
	public void deleteSalaR(Long id) {
		salarRepository.deleteById(id);
	}
}
