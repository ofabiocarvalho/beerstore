package com.hibicode.beerstore.error;

import java.util.Locale;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.RequiredArgsConstructor;

@Order(Ordered.LOWEST_PRECEDENCE)
@RestControllerAdvice
@RequiredArgsConstructor
public class GeneralExceptionHandler {

	private static final String NO_MESSAGE_AVAILABLE = "No message available";
	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(ApiExceptionHandler.class);

	@Autowired
	private ApiExceptionHandler apiExceptionHandler;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception exception, Locale locale){
		LOG.error("Error not expected", exception);
		final String errorCode = "error-1";
		final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		final ErrorResponse errorResponse = ErrorResponse.of(status, apiExceptionHandler.toApiError(errorCode, locale));
		return ResponseEntity.status(status).body(errorResponse);
	}

}
