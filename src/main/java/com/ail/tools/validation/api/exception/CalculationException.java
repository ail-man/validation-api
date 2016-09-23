package com.ail.tools.validation.api.exception;

import com.ail.tools.validation.api.attr.Attribute;

public class CalculationException extends ValidatorException {

	public CalculationException(Throwable cause) {
		super(cause);
	}

	public CalculationException(String message) {
		super(message);
	}

	public CalculationException withAttribute(Attribute attribute) {
		this.setAttribute(attribute);
		return this;
	}

	public CalculationException withErrorCode(ErrorCode errorCode) {
		this.setErrorCode(errorCode);
		return this;
	}
}
