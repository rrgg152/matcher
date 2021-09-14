package com.rookie.player.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class PlayerUserId implements Serializable {
	
	@Column(name = "user_id")
	protected String value;

	public PlayerUserId(String value) {
		this.value = value;
	}
	private PlayerUserId() {
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
		if (!(o instanceof PlayerUserId)) {
			return false;
		}
		PlayerUserId that = (PlayerUserId) o;
		return Objects.equals(value, that.value);
	}

}
