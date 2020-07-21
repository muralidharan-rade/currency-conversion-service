package com.cloudnative.currency;

import java.math.BigDecimal;

public class CurrenyConversionBean {

	private long id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal multiple;
	private BigDecimal calculatedAmount;
	private String port;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public BigDecimal getMultiple() {
		return multiple;
	}

	public void setMultiple(BigDecimal multiple) {
		this.multiple = multiple;
	}

	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	public long getId() {
		return id;
	}

	public CurrenyConversionBean() {
		super();
	}

	public CurrenyConversionBean(long id, String from, String to, BigDecimal quantity) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
	}

	public CurrenyConversionBean(long id, String from, String to, BigDecimal quantity, BigDecimal multiple,
			BigDecimal calculatedAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.multiple = multiple;
		this.calculatedAmount = calculatedAmount;
	}

	public CurrenyConversionBean(long id, String from, String to, BigDecimal quantity, BigDecimal multiple,
			BigDecimal calculatedAmount, String port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.multiple = multiple;
		this.calculatedAmount = calculatedAmount;
		this.port = port;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
