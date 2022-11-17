package com.company.pricing.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.pricing.exceptions.BrandNotFoundException;
import com.company.pricing.exceptions.PriceNotFoundException;
import com.company.pricing.exceptions.ProductNotFoundException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

  @ExceptionHandler({BrandNotFoundException.class, ProductNotFoundException.class, PriceNotFoundException.class})
  public @ResponseBody ExceptionResponse handleResourceNotFound(final RuntimeException exception,
      final HttpServletRequest request) {

    ExceptionResponse error = new ExceptionResponse();
    error.setPath(request.getRequestURI());
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
    error.setMessage(exception.getMessage());

    return error;
  }

}
