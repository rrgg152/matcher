package com.rookie.player.domain;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rookie.player.domain.event.PlayerCreatedEvent;
import com.rookie.shared.domain.AggregateRoot;

@Entity
@Table(name="PLAYERS")
public final class Player extends AggregateRoot {
	@EmbeddedId
	private final PlayerId id;
	@Embedded
	private final PlayerUserId userId;
	@Embedded
	private final PlayerLeagueId leagueId;

	public Player() {
		id = null;
		userId = null;
		leagueId = null;
	}
	public Player(PlayerId id, PlayerUserId userId, PlayerLeagueId leagueId) {
		super();
		this.id = id;
		this.userId = userId;
		this.leagueId = leagueId;
	}

	public PlayerId id() {
		return id;
	}

	public PlayerUserId userId() {
		return userId;
	}

	public PlayerLeagueId leagueId() {
		return leagueId;
	}

	public static Player create(PlayerId id, PlayerUserId userId, PlayerLeagueId leagueId) {
		Player player = new Player(id, userId, leagueId);
		player.record(new PlayerCreatedEvent(id, userId, leagueId));
		return player;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((leagueId == null) ? 0 : leagueId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (leagueId == null) {
			if (other.leagueId != null)
				return false;
		} else if (!leagueId.equals(other.leagueId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


	
	
}
