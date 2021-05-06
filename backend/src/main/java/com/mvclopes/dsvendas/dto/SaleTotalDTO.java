package com.mvclopes.dsvendas.dto;

import java.io.Serializable;

import com.mvclopes.dsvendas.entities.Seller;

public class SaleTotalDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private Double amount;
	
	public SaleTotalDTO() {
	}

	public SaleTotalDTO(Seller seller, Double totalAmount) {
		sellerName = seller.getName();
		this.amount = totalAmount;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getTotalAmount() {
		return amount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.amount = totalAmount;
	}
}
