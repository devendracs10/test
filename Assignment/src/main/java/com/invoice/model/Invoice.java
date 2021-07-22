package com.invoice.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
	private long id;
	private String client;
	private long vatRate;
	private Date invoiceDate;
	
	private List<LineItem> lineItems;

	public Invoice() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "client", nullable = false)
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@Column(name = "vatRate", nullable = false)
	public long getVatRate() {
		return vatRate;
	}

	public void setVatRate(long vatRate) {
		this.vatRate = vatRate;
	}

	@Column(name = "invoiceDate", nullable = false)
	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Invoice(long id, String client, long vatRate, Date invoiceDate) {
		super();
		this.id = id;
		this.client = client;
		this.vatRate = vatRate;
		this.invoiceDate = invoiceDate;
	}
	
	public BigDecimal getSubtotal() {
		BigDecimal subtotal = new BigDecimal("0");
		for (LineItem lineItem : lineItems) {
			subtotal =  lineItem.getUnitPrice().multiply(new BigDecimal(lineItem.getQuantity()));
		}
		return subtotal;
	}
	
	public BigDecimal getVat() {
		return new BigDecimal(vatRate/100);
	}
	
	public BigDecimal getTotal() {
		return getSubtotal().add(getSubtotal().multiply(getVat()));
	}

}
