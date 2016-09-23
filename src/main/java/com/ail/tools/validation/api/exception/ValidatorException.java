package com.ail.tools.validation.api.exception;

import com.ail.tools.validation.api.attr.Attribute;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ValidatorException extends Exception {
	private Attribute attribute;
	private ErrorCode errorCode;

	protected ValidatorException(Throwable cause) {
		super(cause);
	}

	protected ValidatorException(String message) {
		super(message);
	}

	public Attribute getAttribute() {
		return attribute;
	}

	protected void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	protected void setErrorCode(ErrorCode errorCode) {
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
