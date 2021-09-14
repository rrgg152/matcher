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


	
	
}
