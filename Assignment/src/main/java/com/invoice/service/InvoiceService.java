package com.invoice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invoice.model.Invoice;

@Service
public interface InvoiceService {

	public Invoice getInvoiceById(long id);

	public void save(Invoice invoice);

	public List<Invoice> viewAllInvoices();
}