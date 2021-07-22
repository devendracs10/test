package com.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoice.model.LineItem;

public interface LineItemRepository extends JpaRepository<LineItem, Long> {

	public LineItem findById(long id);
}
