package com.hibicode.beerstore.service.exception;

import org.springframework.http.HttpStatus;

import com.hibicode.beerstore.error.BusinessException;

public class BeerAlreadyExistException extends BusinessException {

	public BeerAlreadyExistException() {
		super("beers-5", HttpStatus.BAD_REQUEST);
	}

}
