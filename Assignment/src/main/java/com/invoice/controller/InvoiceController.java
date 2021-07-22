package com.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.invoice.model.Invoice;
import com.invoice.service.InvoiceService;

@RestController
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("/invoices")
	public List<Invoice> viewAllInvoices() {
		return invoiceService.viewAllInvoices();
	}

	@GetMapping("/invoices/{invoiceId}")
	public ResponseEntity<Invoice> viewInvoice(@PathVariable("invoiceId") long invoiceId) throws Exception {
		try {
			Invoice invoice = invoiceService.getInvoiceById(invoiceId);
			return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Invoice>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/invoices")
	public ResponseEntity<Invoice> addInvoice(@RequestBody Invoice invoice) throws Exception {
		try {
			invoiceService.save(invoice);
			return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Invoice>(HttpStatus.BAD_REQUEST);
		}
	}

}