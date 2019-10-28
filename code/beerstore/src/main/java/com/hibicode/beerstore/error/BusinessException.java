package com.hibicode.beerstore.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BusinessException extends RuntimeException {

	private final String code;
	private final HttpStatus status;

}
