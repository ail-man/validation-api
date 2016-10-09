package com.ail.tools.validation.api.exception;

import com.ail.tools.validation.api.attr.Attribute;

public class AttributeCalculationException extends ValidatorException {

	public AttributeCalculationException() {
		super();
	}

	public AttributeCalculationException(Throwable cause) {
		super(cause);
	}

	public AttributeCalculationException(String message) {
		super(message);
	}

	@Override
	public AttributeCalculationException withAttribute(Attribute attribute) {
		return (AttributeCalculationException) super.withAttribute(attribute);
	}

	@Override
	public AttributeCalculationException withErrorCode(ErrorCode errorCode) {
		return (AttributeCalculationException) super.withErrorCode(errorCode);
	}
}
