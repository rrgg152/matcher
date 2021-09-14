package com.rookie.user.application.create;

import com.rookie.shared.domain.bus.command.Command;

public class CreateUserCommand implements Command {

	private final String id;
	
	private final String name;
	
	private final String nick;
	
	private final String password;

	public CreateUserCommand(String id, String name, String nick, String password) {
		super();
		this.id = id;
		this.name = name;
		this.nick = nick;
		this.password = password;
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	public String nick() {
		return nick;
	}

	public String password() {
		return password;
	}
	
	
}
