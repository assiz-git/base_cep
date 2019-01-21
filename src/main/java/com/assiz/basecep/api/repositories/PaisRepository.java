package com.assiz.basecep.api.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assiz.basecep.api.entities.Pais;
import com.assiz.basecep.api.interfaces.EstadoInterface;
import com.assiz.basecep.api.interfaces.PaisInterface;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer>{
	
	Pais findById(Integer id);
	
	Pais findBySigla(String sigla);
	
	@Query(value="Select p.id as id, p.pais as pais, p.sigla as sigla from Pais p where id = :id")
	PaisInterface findByPaisId(Integer id);

    @Query(value="Select e.id as id, e.estado as estado, e.sigla as sigla from Estado e where pais_id = :id")
	List<EstadoInterface> findEstadosByPaisId(Integer id);

}
