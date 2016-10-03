package com.ail.tools.validation.api.exception;

import com.ail.tools.validation.api.attr.Attribute;

public class AttributeExtractionException extends ValidatorException {

	public AttributeExtractionException(Throwable cause) {
		super(cause);
	}

	public AttributeExtractionException(String message) {
		super(message);
	}

	public AttributeExtractionException withAttribute(Attribute attribute) {
		this.setAttribute(attribute);
		return this;
	}

	public AttributeExtractionException withErrorCode(ErrorCode errorCode) {
		this.setErrorCode(errorCode);
		return this;
	}
}
