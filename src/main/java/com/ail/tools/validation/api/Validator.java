package com.ail.tools.validation.api;

public interface Validator<E, V> {

	V validate(E value) throws Exception;

}
