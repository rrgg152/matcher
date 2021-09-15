package com.rookie.player.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.rookie.shared.domain.Identifier;

@SuppressWarnings("serial")
@Embeddable
public class PlayerUserId implements Serializable {
	
	@Column(name = "user_id")
	protected String value;

	public PlayerUserId(String value) {
		Identifier.ensureValidUuid(value);
		this.value = value;
	}
	@SuppressWarnings("unused")
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
