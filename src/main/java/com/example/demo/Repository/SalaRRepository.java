package com.example.demo.Repository;


import com.example.demo.Models.SalaR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

//esto implementa las operaciones CRUD para ser usadas
@Repository("RepositorySalaR")
public interface SalaRRepository extends CrudRepository<SalaR, Long>{
	//public abstract SalaR findById(long id);

	public abstract List<SalaR> findAll();

	public abstract List<SalaR> findByDisponibilidad(Integer disponibilidad);

	public abstract void deleteById(long id);
}
