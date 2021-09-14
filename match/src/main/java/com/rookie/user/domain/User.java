package com.rookie.user.domain;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rookie.shared.domain.AggregateRoot;
import com.rookie.user.domain.event.UserCreatedEvent;

@Entity
@Table(name="MATCH_USERS")
public final class User extends AggregateRoot {
	public static final String ID 		= "id";
	public static final String NAME 	= "name";
	public static final String NICK	 	= "nick";
	public static final String PASSWORD = "password";
	
	@EmbeddedId
	private final UserId id;
	@Embedded
	private final UserName name;
	@Embedded
	private final UserNick nick;
	@Embedded
	private final UserPassword password;

	private User() {
		id = null;
		name = null;
		nick = null;
		password = null;
	}
	public User(UserId id, UserName name, UserNick nick, UserPassword password) {
		this.id = id;
		this.name = name;
		this.nick = nick;
		this.password = password;
	}

	public static User ceate(UserId id, UserName name, UserNick nick, UserPassword password) {
		User user = new User(id, name, nick, password);	
		user.record(new UserCreatedEvent(id, name, nick, password));
		return user;
	}
	public UserId id() {
		return id;
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
