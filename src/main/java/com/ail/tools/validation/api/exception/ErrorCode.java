package com.ail.tools.validation.api.exception;

public enum ErrorCode {

	EMPTY_MANDATORY_ATTRIBUTE,
	ATTRIBUTE_EXTRACTION_ERROR,
	ATTRIBUTE_VALIDATION_ERROR,
	ATTRIBUTE_CALCULATION_ERROR;

	private Description description;

	public ErrorCode withDescription(Description description) {
		this.setDescription(description);
		return this;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}
}