package com.ail.tools.validation.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ValidatedData {

	private final List<Object> list;

	public ValidatedData() {
		this.list = new ArrayList<>();
	}

	public List<Object> getList() {
		return list;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("list", list)
				.toString();
	}
}
