package com.mvclopes.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvclopes.dsvendas.dto.SellerDTO;
import com.mvclopes.dsvendas.entities.Seller;
import com.mvclopes.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired //Injeção de dependência
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		/**
		 * Como vamos retornar um objeto mais simples de dados (DTO) sem conexão ou dependência
		 * como o banco de dados, é necessário criar uma lista do tipo Entidade e convertê-la por 
		 * meio de Stream, utilizando uma função lâmbda
		 */
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
