package com.rookie.player.domain.event;

import java.io.Serializable;
import java.util.HashMap;

import com.rookie.player.domain.PlayerId;
import com.rookie.player.domain.PlayerLeagueId;
import com.rookie.player.domain.PlayerUserId;
import com.rookie.shared.domain.bus.event.DomainEvent;

public class PlayerCreatedEvent extends DomainEvent {

	private final PlayerId id;
	
	private final PlayerUserId userId;
	
	private final PlayerLeagueId leagueId;
	

	public PlayerCreatedEvent(PlayerId id, PlayerUserId userId, PlayerLeagueId leagueId) {
		super(id.value());
		this.id = id;
		this.userId = userId;
		this.leagueId = leagueId;
	}

	@Override
	public String eventName() {
		return "player.created";
	}

	@Override
	public HashMap<String, Serializable> toPrimitives() {
		return null;
	}

	@Override
	public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId,
			String occurredOn) {
		// TODO Auto-generated method stub
		return null;
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
}
