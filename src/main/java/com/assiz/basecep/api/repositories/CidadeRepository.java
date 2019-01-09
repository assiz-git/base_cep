package com.assiz.basecep.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assiz.basecep.api.entities.Cidade;
import com.assiz.basecep.api.interfaces.BairroInterface;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

	Cidade findById(Integer id);
	
    @Query(value="Select c from Cidade c where cidade = :cidade and estado_id = :estadoId")
	Cidade findByCidadeAndEstadoId(String cidade, Integer estadoId);

    @Query(value="Select b.id as id, b.bairro as bairro from Bairro b where cidade_id = :id")
	List<BairroInterface> findBairrosByCidadeId(Integer id);

}
