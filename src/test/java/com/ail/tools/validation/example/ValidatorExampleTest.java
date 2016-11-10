package com.ail.tools.validation.example;

import java.util.List;
import java.util.Map;

import com.ail.tools.validation.api.exception.ValidatorException;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidatorExampleTest {

	private static final Logger logger = LoggerFactory.getLogger(ValidatorExampleTest.class);

	@Test
	public void testValidateData() {
		InputData inputData = new InputData();
		Map<String, String> map = inputData.getMap();
		map.put("integer", "1234");
		map.put("boolean", "true");
		map.put("long", "a23125125235");

		ValidatorExample validator = new ValidatorExample(logger);
		Pair<ValidatedData, List<ValidatorException>> result = validator.validateData(inputData);
		logger.debug(result.getLeft().toString());
		logger.debug(result.getRight().toString());
	}
}