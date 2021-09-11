package com.dog.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dog.cursospring.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
	
	@Transactional(readOnly = true)
	Cliente findByEmail(String email);
	

	@Transactional(readOnly = true)
	Cliente findByCpfCnpj(String cpfCnpj);
	
}
