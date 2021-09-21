package com.rookie.league.domain;

import com.rookie.shared.domain.UuidMother;

public class LeagueIdMother {
    
    public static LeagueId create(String value) {
		return new LeagueId(value);
	}
	public static LeagueId random() {
		return create(UuidMother.random());
	}
}
