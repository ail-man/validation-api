package com.ail.tools.validation.api.exception;

import com.ail.tools.validation.api.attr.Attribute;

public class AttributeValidationException extends ValidatorException {

	public AttributeValidationException(Throwable cause) {
		super(cause);
	}

	public AttributeValidationException(String message) {
		super(message);
	}

	@Override
	public AttributeValidationException withAttribute(Attribute attribute) {
		return (AttributeValidationException) super.withAttribute(attribute);
	}

	@Override
	public AttributeValidationException withErrorCode(ErrorCode errorCode) {
		return (AttributeValidationException) super.withErrorCode(errorCode);
	}

}
