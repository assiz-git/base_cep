package com.assiz.basecep.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assiz.basecep.api.entities.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, String>{

	Cep findByCep(String cep);

}
