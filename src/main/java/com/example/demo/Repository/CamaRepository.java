package com.example.demo.Repository;

import com.example.demo.Models.Cama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

//esto implementa las operaciones CRUD para ser usadas
@Repository("RepositoryCama")
public interface CamaRepository extends CrudRepository<Cama, Long>{
	//public Cama findById(Long id);

	public List<Cama> findAll();

	public List<Cama> findByEstado(String estado);//para filtrar por estado
}
