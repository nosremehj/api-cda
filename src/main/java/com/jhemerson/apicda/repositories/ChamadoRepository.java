package com.jhemerson.apicda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhemerson.apicda.domain.Chamado;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
