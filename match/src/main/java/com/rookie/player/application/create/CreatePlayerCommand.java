package com.rookie.player.application.create;

import com.rookie.shared.domain.bus.command.Command;

public class CreatePlayerCommand implements Command {

	private final String id;
	
	private final String userId;
	
	private final String leagueId;	
	

	public CreatePlayerCommand(String id, String userId, String leagueId) {
		super();
		this.id = id;
		this.userId = userId;
		this.leagueId = leagueId;
	}

	public String id() {
		return id;
	}

	public String userId() {
		return userId;
	}

	public String leagueId() {
		return leagueId;
	}
	
	
}
