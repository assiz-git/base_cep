package com.assiz.basecep.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assiz.basecep.api.entities.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer>{

}
