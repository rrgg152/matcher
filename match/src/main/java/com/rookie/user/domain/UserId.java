package com.rookie.user.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class UserId implements Serializable {
	@Column(name = "ID")
	private final String value;

	public UserId(String value) {
		ensureValidUuid(value);
		this.value = value;
	}

	protected UserId() {
		value = null;
	}

	public String value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		UserId that = (UserId) o;
		return value.equals(that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	private void ensureValidUuid(String value) throws IllegalArgumentException {
		UUID.fromString(value);
	}
}
