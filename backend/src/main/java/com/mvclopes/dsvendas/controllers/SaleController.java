package com.mvclopes.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvclopes.dsvendas.dto.SaleDTO;
import com.mvclopes.dsvendas.dto.SaleTotalDTO;
import com.mvclopes.dsvendas.dto.SuccessRateDTO;
import com.mvclopes.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable page) {
		Page<SaleDTO> result = service.findAll(page);
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleTotalDTO>> amountGroupedBySeller() {
		List<SaleTotalDTO> result = service.amountGroupedBySeller();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/success-rate-by-seller")
	public ResponseEntity<List<SuccessRateDTO>> successRateGroupedBySeller(){
		List<SuccessRateDTO> result = service.successRateGroupedBySeller();
		return ResponseEntity.ok(result);
	}
}
