package com.dog.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dog.cursospring.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer>{
	
}
