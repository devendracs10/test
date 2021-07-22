package com.invoice.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.invoice.model.Invoice;
import com.invoice.repository.InvoiceRepository;
import com.invoice.service.InvoiceService;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoicerepo;

	public void save(Invoice doc) {
		invoicerepo.save(doc);
	}

	@Override
	public List<Invoice> viewAllInvoices() {
		// TODO Auto-generated method stub
		return invoicerepo.findAll();
	}

	@Override
	public Invoice getInvoiceById(long id) {
		return invoicerepo.findById(id);
	}

}