package com.mvclopes.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvclopes.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
