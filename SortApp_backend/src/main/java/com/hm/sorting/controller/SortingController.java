package com.hm.sorting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hm.sorting.domain.SortedResult;
import com.hm.sorting.service.SortingService;

@RestController
public class SortingController {

	@Autowired
	private SortingService sortingService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "sorting", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
	public SortedResult getSortedNumber(final String sortNumbers) {
		return sortingService.sortOrder(sortNumbers);
	}
}
