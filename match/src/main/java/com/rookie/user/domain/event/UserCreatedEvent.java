package com.rookie.user.domain.event;

import java.io.Serializable;
import java.util.HashMap;

import com.rookie.shared.domain.bus.event.DomainEvent;
import com.rookie.user.domain.UserId;
import com.rookie.user.domain.UserName;
import com.rookie.user.domain.UserNick;
import com.rookie.user.domain.UserPassword;

public class UserCreatedEvent extends DomainEvent {

	
	private final UserName name;
	
	private final UserNick nick;
	
	private final UserPassword password;
	


	public UserCreatedEvent(UserId aggregateId, UserName name, UserNick nick, UserPassword password) {
		super(aggregateId.value());
		this.name = name;
		this.nick = nick;
		this.password = password;
	}

	@Override
	public String eventName() {
		return "user.created";
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

	public UserName name() {
		return name;
	}

	public UserNick nick() {
		return nick;
	}

	public UserPassword password() {
		return password;
	}
}
