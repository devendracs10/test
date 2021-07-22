package com.invoice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.invoice.model.LineItem;
import com.invoice.repository.LineItemRepository;
import com.invoice.service.LineItemService;

public class LineItemServiceImpl implements LineItemService {

	@Autowired
	LineItemRepository lineItemRepo;
	
	@Override
	public LineItem getLineById(long id) {
		 return lineItemRepo.findById(id);
	}

	@Override
	public void save(LineItem lineItem) {
		lineItemRepo.save(lineItem);
		
	}

	@Override
	public List<LineItem> viewAllLineItem() {
		return lineItemRepo.findAll();
	}

}
