package com.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.model.LineItem;
import com.invoice.service.LineItemService;

@RestController
public class LineItemController {

	@Autowired
	private LineItemService lineItemService;

	@GetMapping("/lineitem")
	public List<LineItem> viewAllLineItem() {
		return lineItemService.viewAllLineItem();
	}

	@GetMapping("/lineitem/{id}")
	public ResponseEntity<LineItem> getLineItemById(@PathVariable("id") long id) throws Exception {
		try {
			LineItem lineItem = lineItemService.getLineById(id);
			return new ResponseEntity<LineItem>(lineItem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<LineItem>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/lineitem")
	public ResponseEntity<LineItem> createLineItem(@RequestBody LineItem lineItem) throws Exception {
		try {
			lineItemService.save(lineItem);
			return new ResponseEntity<LineItem>(lineItem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<LineItem>(HttpStatus.BAD_REQUEST);
		}
	}
}
