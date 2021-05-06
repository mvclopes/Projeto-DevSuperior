package com.mvclopes.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mvclopes.dsvendas.dto.SaleTotalDTO;
import com.mvclopes.dsvendas.dto.SuccessRateDTO;
import com.mvclopes.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	/**
	 * Anotação @Query para atribuir determinado comando SQL ao método
	 * 
	 */
	@Query("SELECT new com.mvclopes.dsvendas.dto.SaleTotalDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleTotalDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.mvclopes.dsvendas.dto.SuccessRateDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SuccessRateDTO> successRateGroupedBySeller();

}
