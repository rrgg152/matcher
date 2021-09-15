package com.rookie.player.domain;

import com.rookie.player.application.create.CreatePlayerCommand;

public class PlayerMother {
    public static Player create(PlayerId  id, PlayerUserId userId, PlayerLeagueId leagueId){
        return new Player(id, userId, leagueId);
    }
    public static Player random(){
        return create(PlayerIdMother.random(), PlayerUserIdMother.random(), PlayerLeagueIdMother.random());
    }
    public static Player fromRequest(CreatePlayerCommand request) {
		return create(PlayerIdMother.create(request.id()), 
					  PlayerUserIdMother.create(request.userId()),
					  PlayerLeagueIdMother.create(request.leagueId()));
	  }    
}
