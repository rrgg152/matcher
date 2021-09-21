package com.rookie.player.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rookie.league.domain.LeagueId;
import com.rookie.player.domain.event.PlayerCreatedEvent;
import com.rookie.shared.domain.AggregateRoot;
import com.rookie.user.domain.UserId;

@Entity
@Table(name="PLAYERS")
public final class Player extends AggregateRoot {
	@Id
	@Column(name = "ID")
	private final String id;

	@Column(name = "user_id")
	private final String userId;

	@Column(name = "league_id")
	private final String leagueId;

	public Player() {
		id = null;
		userId = null;
		leagueId = null;
	}
	public Player(PlayerId id, UserId userId, LeagueId leagueId) {
		super();
		this.id = id.value();
		this.userId = userId.value();
		this.leagueId = leagueId.value();
	}

	public PlayerId id() {
		return new PlayerId(id);
	}

	public UserId userId() {
		return new UserId(userId);
	}

	public LeagueId leagueId() {
		return new LeagueId(leagueId);
	}

	public static Player create(PlayerId id, UserId userId, LeagueId leagueId) {
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
