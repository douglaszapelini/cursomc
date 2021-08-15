package com.dog.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dog.cursospring.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
	
}
