package com.example.demo.Repository;


import com.example.demo.Models.PRecuperacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

//esto implementa las operaciones CRUD para ser usadas
@Repository("RepositoryPRecuperacion")
public interface PRecuperacionRepository extends CrudRepository<PRecuperacion, Long>{
	//public abstract PRecuperacion findById(long id);

	public abstract List<PRecuperacion> findAll();

	public abstract List<PRecuperacion> findByCargo(String cargo);

	public abstract void deleteById(long id);
}
