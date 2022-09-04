package com.jhemerson.apicda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhemerson.apicda.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
