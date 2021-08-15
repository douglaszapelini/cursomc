package com.dog.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dog.cursospring.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Integer>{
	
}
