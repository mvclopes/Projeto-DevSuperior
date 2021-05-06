package com.mvclopes.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvclopes.dsvendas.dto.SaleDTO;
import com.mvclopes.dsvendas.dto.SaleTotalDTO;
import com.mvclopes.dsvendas.dto.SuccessRateDTO;
import com.mvclopes.dsvendas.entities.Sale;
import com.mvclopes.dsvendas.repositories.SaleRepository;
import com.mvclopes.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable page){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(page);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleTotalDTO> amountGroupedBySeller(){
		List<SaleTotalDTO> result = repository.amountGroupedBySeller();
		return result;
	}
	
	@Transactional(readOnly = true)
	public List<SuccessRateDTO> successRateGroupedBySeller(){
		List<SuccessRateDTO> result = repository.successRateGroupedBySeller();
		return result;
	}
}
