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

public abstract class AbstractValidator<S, T> {

	protected final Logger logger;

	protected AbstractValidator(Logger logger) {
		this.logger = logger;
	}

	protected abstract Pair<T, List<ValidatorException>> validateData(final S data);

	protected <V> V extract(Attribute attribute, AttributeExtractor<V> attributeExtractor) throws AttributeExtractionException {
		V extractedValue = null;
		try {
			extractedValue = attributeExtractor.extract();
			if (extractedValue == null && attribute.getMandatory()) {
				throw new AttributeExtractionException()
						.withAttribute(attribute)
						.withErrorCode(ErrorCode.EMPTY_MANDATORY_ATTRIBUTE);
			}
		} catch (Exception e) {
			if (attribute.getMandatory()) {
				throw new AttributeExtractionException(e)
						.withAttribute(attribute)
						.withErrorCode(ErrorCode.ATTRIBUTE_EXTRACTION_ERROR);
			}
		}
		if (logger != null && attribute.getLoggable()) {
			logger.trace("Extracted {}={}", attribute.getName(), extractedValue);
		}
		return extractedValue;
	}

	protected <V> V calculate(Attribute attribute, AttributeCalculator<V> attributeCalculator) throws AttributeCalculationException {
		V calculatedValue = null;
		try {
			calculatedValue = attributeCalculator.calculate();
			if (calculatedValue == null && attribute.getMandatory()) {
				throw new AttributeCalculationException()
						.withAttribute(attribute)
						.withErrorCode(ErrorCode.EMPTY_MANDATORY_ATTRIBUTE);
			}
		} catch (Exception e) {
			if (attribute.getMandatory()) {
				throw new AttributeCalculationException(e)
						.withAttribute(attribute)
						.withErrorCode(ErrorCode.ATTRIBUTE_CALCULATION_ERROR);
			}
		}
		if (logger != null && attribute.getLoggable()) {
			logger.trace("Calculated {}={}", attribute.getName(), calculatedValue);
		}
		return calculatedValue;
	}

	protected <E, V> V validate(Attribute attribute, AttributeValidator<E, V> attributeValidator, E value) throws AttributeValidationException {
		attribute.setValue(value);
		V validatedValue = null;
		try {
			validatedValue = attributeValidator.validate(value);
			if (validatedValue == null && attribute.getMandatory()) {
				throw new AttributeValidationException()
						.withAttribute(attribute)
						.withErrorCode(ErrorCode.EMPTY_MANDATORY_ATTRIBUTE);
			}
		} catch (Exception e) {
			if (attribute.getMandatory()) {
				throw new AttributeValidationException(e)
						.withAttribute(attribute)
						.withErrorCode(ErrorCode.ATTRIBUTE_VALIDATION_ERROR);
			}
		}
		if (logger != null && attribute.getLoggable()) {
			logger.trace("Validated {}={}", attribute.getName(), validatedValue);
		}
		return validatedValue;
	}

	protected <E, V> V validate(Attribute fromAttribute, AttributeExtractor<E> attributeExtractor, Attribute toAttribute, AttributeValidator<E, V> attributeValidator) throws AttributeValidationException, AttributeExtractionException {
		return validate(toAttribute, attributeValidator, extract(fromAttribute, attributeExtractor));
	}

	protected <E, V> V validate(Attribute attribute, AttributeExtractor<E> attributeExtractor, AttributeValidator<E, V> attributeValidator) throws AttributeValidationException, AttributeExtractionException {
		return validate(attribute, attributeValidator, extract(attribute, attributeExtractor));
	}

}
