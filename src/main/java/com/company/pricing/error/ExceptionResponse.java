package com.company.pricing.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {

	private String message;
	private String path;
	private Integer status;
	private String error;

}