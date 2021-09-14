package com.rookie.league.domain;

import com.rookie.shared.domain.Identifier;

@SuppressWarnings("serial")
public class LeagueId extends Identifier {
	protected LeagueId() {}
	
	public LeagueId(String value) {
		super(value);
	}
}