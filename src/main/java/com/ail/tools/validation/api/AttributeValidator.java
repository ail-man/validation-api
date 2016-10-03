package com.ail.tools.validation.api;

public interface AttributeValidator<E, V> {

	V validate(E value) throws Exception;

}
