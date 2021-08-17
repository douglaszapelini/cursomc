package com.dog.cursospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.cursospring.domain.Pedido;
import com.dog.cursospring.repositories.PedidoRepository;
import com.dog.cursospring.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id:" + id + 
																	", Tipo: " + Pedido.class.getName())); 
	}

}
