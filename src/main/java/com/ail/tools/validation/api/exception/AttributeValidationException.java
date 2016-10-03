package com.ail.tools.validation.api.exception;

import com.ail.tools.validation.api.attr.Attribute;

public class AttributeValidationException extends ValidatorException {

	public AttributeValidationException(Throwable cause) {
		super(cause);
	}

	public AttributeValidationException(String message) {
		super(message);
	}

	public AttributeValidationException withAttribute(Attribute attribute) {
		this.setAttribute(attribute);
		return this;
	}

	public AttributeValidationException withErrorCode(ErrorCode errorCode) {
		this.setErrorCode(errorCode);
		return this;
	}

}
