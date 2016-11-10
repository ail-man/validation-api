package com.ail.tools.validation.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ail.tools.validation.api.AbstractValidator;
import com.ail.tools.validation.api.AttributeValidator;
import com.ail.tools.validation.api.attr.Attribute;
import com.ail.tools.validation.api.exception.AttributeValidationException;
import com.ail.tools.validation.api.exception.ValidatorException;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;

public class ValidatorExample extends AbstractValidator<InputData, ValidatedData> {

	public ValidatorExample(Logger logger) {
		super(logger);
	}

	@Override
	public Pair<ValidatedData, List<ValidatorException>> validateData(InputData inputData) {
		ValidatedData validatedData = new ValidatedData();
		List<ValidatorException> errors = new ArrayList<>();

		final Map<String, String> map = inputData.getMap();

		for (final String key : map.keySet()) {
			try {
				validatedData.getList().add(validate(
						new Attribute(key),
						() -> map.get(key),
						(AttributeValidator<String, Object>) value -> {
							switch (key) {
							case "integer":
								return Integer.parseInt(value);
							case "boolean":
								return Boolean.parseBoolean(value);
							case "long":
								return Long.parseLong(value);
							}
							throw new AttributeValidationException();
						}
				));
			} catch (ValidatorException e) {
				errors.add(e);
			}
		}

		return Pair.of(validatedData, errors);
	}

}
