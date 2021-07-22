package com.invoice.service;

import java.util.List;

import com.invoice.model.LineItem;

public interface LineItemService {

	public LineItem getLineById(long id);

	public void save(LineItem lineItem);

	public List<LineItem> viewAllLineItem();

}
