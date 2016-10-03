package com.ail.tools.validation.api.exception;

import com.ail.tools.validation.api.attr.Attribute;

public class AttributeCalculationException extends ValidatorException {

	public AttributeCalculationException(Throwable cause) {
		super(cause);
	}

	public AttributeCalculationException(String message) {
		super(message);
	}

	public AttributeCalculationException withAttribute(Attribute attribute) {
		this.setAttribute(attribute);
		return this;
	}

	public AttributeCalculationException withErrorCode(ErrorCode errorCode) {
		this.setErrorCode(errorCode);
		return this;
	}
}
