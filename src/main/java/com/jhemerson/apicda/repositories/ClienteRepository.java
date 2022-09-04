package com.jhemerson.apicda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhemerson.apicda.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
