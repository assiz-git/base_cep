package com.assiz.basecep.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assiz.basecep.api.entities.Estado;
import com.assiz.basecep.api.interfaces.CidadeInterface;
import com.assiz.basecep.api.interfaces.EstadoInterface;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	
	Estado findById(Integer id);
	
	Estado findBySigla(String sigla);
	
	@Query(value="Select e.id as id, e.estado as estado, e.sigla as sigla from Estado e where id = :id")
	EstadoInterface findByEstadoId(Integer id);

    @Query(value="Select c.id as id, c.cidade as cidade from Cidade c where estado_id = :id")
	List<CidadeInterface> findCidadesByEstadoId(Integer id);

}
