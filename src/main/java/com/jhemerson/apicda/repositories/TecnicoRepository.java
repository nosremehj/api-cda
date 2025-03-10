package com.jhemerson.apicda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhemerson.apicda.domain.Tecnico;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
