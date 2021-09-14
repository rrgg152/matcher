package com.rookie.league.domain;

public final class League {

	private final LeagueId id;
	
	private final LeagueDivision division;

	public League(LeagueId id, LeagueDivision division) {
		super();
		this.id = id;
		this.division = division;
	}

	public LeagueId id() {
		return id;
	}

	public LeagueDivision division() {
		return division;
	}
	
	
}
