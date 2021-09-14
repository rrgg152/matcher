package com.rookie.player.domain;

import java.util.Objects;

import javax.persistence.Column;

public final class PlayerLeagueId {
	
	@Column(name = "league_id")
	protected String value;

	public PlayerLeagueId(String value) {
		this.value = value;
	}
	private PlayerLeagueId() {
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
		if (!(o instanceof PlayerLeagueId)) {
			return false;
		}
		PlayerLeagueId that = (PlayerLeagueId) o;
		return Objects.equals(value, that.value);
	}

}