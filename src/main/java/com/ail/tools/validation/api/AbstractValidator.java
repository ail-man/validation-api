package com.ail.tools.validation.api;

import java.util.List;

import com.ail.tools.validation.api.attr.Attribute;
import com.ail.tools.validation.api.exception.AttributeCalculationException;
import com.ail.tools.validation.api.exception.AttributeExtractionException;
import com.ail.tools.validation.api.exception.AttributeValidationException;
import com.ail.tools.validation.api.exception.ErrorCode;
import com.ail.tools.validation.api.exception.ValidatorException;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;

public abstract class AbstractValidator<T, S> {

	protected final Logger logger;

	protected AbstractValidator(Logger logger) {
		this.logger = logger;
	}

	protected abstract Pair<T, List<ValidatorException>> validateData(final S data);

	protected <V> V extract(Attribute attribute, Extractor<V> extractor) throws AttributeExtractionException {
		V extractedValue = null;
		try {
			extractedValue = extractor.extract();
			if (logger != null && attribute.getLoggable() != Boolean.FALSE) {
				logger.trace("Extracted {}={}", attribute.getName(), extractedValue);
			}
			if (extractedValue == null && attribute.getMandatory() == Boolean.TRUE) {
				throw new AttributeExtractionException("Mandatory attribute")
						.withAttribute(attribute)
						.withErrorCode(ErrorCode.EMPTY_MANDATORY_ATTRIBUTE);
			}
		} catch (Exception e) {
			if (attribute.getMandatory() == Boolean.TRUE) {
				throw new AttributeExtractionException(e)
						.withAttribute(attribute)
						.withErrorCode(ErrorCode.ATTRIBUTE_EXTRACTION_ERROR);
			}
		}
		return extractedValue;
	}

	protected <V> V calculate(Attribute attribute, Calculator<V> calculator) throws AttributeCalculationException {
		V calculatedValue = null;
		try {
			calculatedValue = calculator.calculate();
			if (logger != null && attribute.getLoggable() != Boolean.FALSE) {
				logger.trace("Calculated {}={}", attribute.getName(), calculatedValue);
			}
			if (calculatedValue == null && attribute.getMandatory() == Boolean.TRUE) {
				throw new AttributeCalculationException("Mandatory attribute")
						.withAttribute(attribute)
						.withErrorCode(ErrorCode.EMPTY_MANDATORY_ATTRIBUTE);
			}
		} catch (Exception e) {
			if (attribute.getMandatory() == Boolean.TRUE) {
				throw new AttributeCalculationException(e)
						.withAttribute(attribute)
						.withErrorCode(ErrorCode.ATTRIBUTE_CALCULATION_ERROR);
			}
		}
		return calculatedValue;
	}

	protected <E, V> V validate(Attribute attribute, Validator<E, V> validator, E value) throws AttributeValidationException {
		attribute.setValue(value);
		V validatedValue = null;
		try {
			validatedValue = validator.validate(value);
			if (logger != null && attribute.getLoggable() != Boolean.FALSE) {
				logger.trace("Validated {}={}", attribute.getName(), validatedValue);
			}
			if (validatedValue == null && attribute.getMandatory() == Boolean.TRUE) {
				throw new AttributeValidationException("Mandatory attribute")
						.withAttribute(attribute)
						.withErrorCode(ErrorCode.EMPTY_MANDATORY_ATTRIBUTE);
			}
		} catch (Exception e) {
			if (attribute.getMandatory() == Boolean.TRUE) {
				throw new AttributeValidationException(e)
						.withAttribute(attribute)
						.withErrorCode(ErrorCode.ATTRIBUTE_VALIDATION_ERROR);
			}
		}
		return validatedValue;
	}

	protected <E, V> V validate(Attribute fromAttribute, Extractor<E> extractor, Attribute toAttribute, Validator<E, V> validator) throws AttributeValidationException, AttributeExtractionException {
		return validate(toAttribute, validator, extract(fromAttribute, extractor));
	}

	protected <E, V> V validate(Attribute attribute, Extractor<E> extractor, Validator<E, V> validator) throws AttributeValidationException, AttributeExtractionException {
		return validate(attribute, validator, extract(attribute, extractor));
	}

}
