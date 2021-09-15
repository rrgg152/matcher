package com.rookie.user.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserPassword {

	@Column(name = "password")
	protected String value;

	public UserPassword(String value) {
		this.value = value;
	}
	@SuppressWarnings("unused")
	private UserPassword() {
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
		if (!(o instanceof UserPassword)) {
			return false;
		}
		UserPassword that = (UserPassword) o;
		return Objects.equals(value, that.value);
	}
}
