package com.ail.tools.validation.api.exception;

import com.ail.tools.validation.api.attr.Attribute;

public class ExtractionException extends ValidatorException {

	public ExtractionException(Throwable cause) {
		super(cause);
	}

	public ExtractionException(String message) {
		super(message);
	}

	public ExtractionException withAttribute(Attribute attribute) {
		this.setAttribute(attribute);
		return this;
	}

	public ExtractionException withErrorCode(ErrorCode errorCode) {
		this.setErrorCode(errorCode);
		return this;
	}
}
