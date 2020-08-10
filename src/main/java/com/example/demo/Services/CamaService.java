package com.example.demo.Services;


import com.example.demo.Models.Cama;
import com.example.demo.NotFoundE.CamaNFE;
import com.example.demo.Repository.CamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("ServicioCama")
public class CamaService {

	@Autowired
	@Qualifier("RepositoryCama")
	private CamaRepository camaRepository;


	//request
	public Iterable<Cama> listAll() {
			return (camaRepository.findAll());
		}
	public Optional<Cama> listOne(Long id) {
			return (camaRepository.findById(id));
	}
	public List<Cama> listByEstado(String estado) {
		return (camaRepository.findByEstado(estado));
	}
	//create & update
	public Cama saveOrUpdateCama(Cama cama) {
		return camaRepository.save(cama);
	}



	//delete 1 cama por su id

	public void deleteCama(Long id) {
		camaRepository.deleteById(id);
	}
	public Cama getCama(Long id) {
		return camaRepository.findById(id)
				.orElseThrow(() -> new CamaNFE(id));
	}
	public List<Cama> getCama(String estado) {
		return camaRepository.findByEstado(estado);
	}
}
