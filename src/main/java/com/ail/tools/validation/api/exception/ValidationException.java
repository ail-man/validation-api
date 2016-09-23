package com.ail.tools.validation.api.exception;

import com.ail.tools.validation.api.attr.Attribute;

public class ValidationException extends ValidatorException {

	public ValidationException(Throwable cause) {
		super(cause);
	}

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException withAttribute(Attribute attribute) {
		this.setAttribute(attribute);
		return this;
	}

	public ValidationException withErrorCode(ErrorCode errorCode) {
		this.setErrorCode(errorCode);
		return this;
	}

}
