package com.rookie.user.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class UserName {
	
	@Column(name = "name")
	protected String value;

	public UserName(String value) {
		this.value = value;
	}
	@SuppressWarnings("unused")
	private UserName() {
		value = null;
	}
	public String value() {
		return value;
	}

	@Override
	public String toString() {
		return value();
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof UserName)) {
			return false;
		}
		UserName that = (UserName) o;
		return Objects.equals(value, that.value);
	}

}
