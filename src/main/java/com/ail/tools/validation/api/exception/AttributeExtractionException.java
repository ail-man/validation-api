package com.ail.tools.validation.api.exception;

import com.ail.tools.validation.api.attr.Attribute;

public class AttributeExtractionException extends ValidatorException {

	public AttributeExtractionException() {
		super();
	}

	public AttributeExtractionException(Throwable cause) {
		super(cause);
	}

	public AttributeExtractionException(String message) {
		super(message);
	}

	@Override
	public AttributeExtractionException withAttribute(Attribute attribute) {
		return (AttributeExtractionException) super.withAttribute(attribute);
	}

	@Override
	public AttributeExtractionException withErrorCode(ErrorCode errorCode) {
		return (AttributeExtractionException) super.withErrorCode(errorCode);
	}
}
