package com.dog.cursospring.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dog.cursospring.domain.enums.TipoCliente;
import com.dog.cursospring.dto.ClienteNewDTO;
import com.dog.cursospring.repositories.ClienteRepository;
import com.dog.cursospring.resources.exception.FieldMessage;
import com.dog.cursospring.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		//Valida CPF/CNPJ
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfCnpj())) {
			list.add(new FieldMessage("cpfCnpj", "CPF Inválido!"));
		} else if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfCnpj())){
			list.add(new FieldMessage("cpfCnpj", "CNPJ Inválido!"));
		}
		//Verifica se já existe CPF/CNPJ cadastrado
		if(repo.findByCpfCnpj(objDto.getCpfCnpj()) != null) {
			list.add(new FieldMessage("cpfCnpj", 
					(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) ? "CPF" : "CNPJ") + " já existente!"));
		}
		//Verifica se já existe e-mail cadastrado
		if(repo.findByEmail(objDto.getEmail()) != null) {
			list.add(new FieldMessage("email", "E-mail já existente!"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
