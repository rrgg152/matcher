package com.rookie.player.domain.event;

import java.io.Serializable;
import java.util.HashMap;

import com.rookie.league.domain.LeagueId;
import com.rookie.player.domain.PlayerId;
import com.rookie.shared.domain.bus.event.DomainEvent;
import com.rookie.user.domain.UserId;

public class PlayerCreatedEvent extends DomainEvent {

	private final PlayerId id;
	
	private final UserId userId;
	
	private final LeagueId leagueId;
	

	public PlayerCreatedEvent(PlayerId id, UserId userId, LeagueId leagueId) {
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

	public UserId userId() {
		return userId;
	}

	public LeagueId leagueId() {
		return leagueId;
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
		PlayerCreatedEvent other = (PlayerCreatedEvent) obj;
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
