package com.currency.currency_converter;

import java.math.BigDecimal;

public class CurrencyConversionBean
{
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private int port;

	public CurrencyConversionBean()
	{

	}

	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmount, int port)
	{
		super();
		this.setId(id);
		this.from = from;
		this.to = to;
		this.setConversionMultiple(conversionMultiple);
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.setPort(port);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}