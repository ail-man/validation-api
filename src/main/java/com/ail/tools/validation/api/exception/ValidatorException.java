package com.ail.tools.validation.api.exception;

import com.ail.tools.validation.api.attr.Attribute;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ValidatorException extends Exception {
	private Attribute attribute;
	private ErrorCode errorCode;

	public ValidatorException(Throwable cause) {
		super(cause);
	}

	public ValidatorException(String message) {
		super(message);
	}

	public ValidatorException withAttribute(Attribute attribute) {
		this.setAttribute(attribute);
		return this;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public ValidatorException withErrorCode(ErrorCode errorCode) {
		this.setErrorCode(errorCode);
		return this;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String getMessage() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Message", super.getMessage())
				.append("Attribute", attribute)
				.append("ErrorCode", errorCode)
				.toString();
	}
}
