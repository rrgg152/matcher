package com.rookie.user.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public final class UserNick {

	@Column(name = "nick")
	protected String value;

	public UserNick(String value) {
		this.value = value;
	}
	@SuppressWarnings("unused")
	private UserNick() {
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
		if (!(o instanceof UserNick)) {
			return false;
		}
		UserNick that = (UserNick) o;
		return Objects.equals(value, that.value);
	}
}
