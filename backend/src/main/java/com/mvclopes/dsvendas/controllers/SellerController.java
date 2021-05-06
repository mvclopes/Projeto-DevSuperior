package com.mvclopes.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvclopes.dsvendas.dto.SellerDTO;
import com.mvclopes.dsvendas.services.SellerService;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {
	
	@Autowired
	private SellerService service;
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll(){
		/**
		 * Endpoint para capturar todas as entidades da lista de tipo DTO e
		 * verificar a resposta HTTP, onde o método .ok tem como resposta de valor 200
		 */
		List<SellerDTO> result = service.findAll();
		return ResponseEntity.ok(result);
	}

}
