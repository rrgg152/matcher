package com.rookie.user.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	@Column(name = "ID")
	@Id
	private final String id;

	@Column(name = "name")
	private final String name;

	@Column(name = "nick")
	private final String nick;

	@Column(name = "password")
	private final String password;

	@SuppressWarnings("unused")
	private User() {
		id = null;
		name = null;
		nick = null;
		password = null;
	}
	public User(UserId id, UserName name, UserNick nick, UserPassword password) {
		this.id = id.value();
		this.name = name.value();
		this.nick = nick.value();
		this.password = password.value();
	}

	public static User ceate(UserId id, UserName name, UserNick nick, UserPassword password) {
		User user = new User(id, name, nick, password);	
		user.record(new UserCreatedEvent(id, name, nick, password));
		return user;
	}
	public UserId id() {
		return new UserId(id);
	}

	public UserName name() {
		return new UserName(name);
	}

	public UserNick nick() {
		return new UserNick(nick);
	}

	public UserPassword password() {
		return new UserPassword(password);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, nick, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(nick, other.nick)
				&& Objects.equals(password, other.password);
	}
	
	
	
}
