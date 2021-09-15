package com.rookie.player.domain;

import com.rookie.shared.domain.UuidMother;

public class PlayerLeagueIdMother {
    public static PlayerLeagueId create(String value){
        return new PlayerLeagueId(value);
    }
    public static PlayerLeagueId random(){
        return create(UuidMother.random());
    }
}
