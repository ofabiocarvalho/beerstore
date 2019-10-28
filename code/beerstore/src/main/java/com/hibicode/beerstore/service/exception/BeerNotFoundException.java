package com.hibicode.beerstore.service.exception;

import org.springframework.http.HttpStatus;

import com.hibicode.beerstore.error.BusinessException;

public class BeerNotFoundException extends BusinessException {

	public BeerNotFoundException() {
		super("beers-6", HttpStatus.NOT_FOUND);
	}

}
