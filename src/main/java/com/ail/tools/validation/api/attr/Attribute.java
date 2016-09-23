package com.ail.tools.validation.api.attr;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Attribute {

	private final String name;
	private Boolean mandatory = Boolean.TRUE;
	private HolderType holderType;
	private Object holderId;
	private Object value;
	private Boolean loggable = Boolean.TRUE;

	public Attribute(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Boolean getMandatory() {
		return mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Attribute nonMandatory() {
		this.setMandatory(Boolean.FALSE);
		return this;
	}

	public HolderType getHolderType() {
		return holderType;
	}

	public void setHolderType(HolderType holderType) {
		this.holderType = holderType;
	}

	public Attribute withHolderType(HolderType holderType) {
		this.setHolderType(holderType);
		return this;
	}

	public Object getHolderId() {
		return holderId;
	}

	public void setHolderId(Object holderId) {
		this.holderId = holderId;
	}

	public Attribute withHolderId(Object holderId) {
		this.setHolderId(holderId);
		return this;
	}

	public Boolean getLoggable() {
		return loggable;
	}

	public void setLoggable(Boolean loggable) {
		this.loggable = loggable;
	}

	public Attribute notLoggable() {
		this.setLoggable(Boolean.FALSE);
		return this;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Attribute withValue(Object value) {
		this.setValue(value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Name", name)
				.append("Mandatory", mandatory)
				.append("Value", value)
				.append("HolderType", holderType)
				.append("HolderId", holderId)
				.append("Loggable", loggable)
				.toString();
	}

}
