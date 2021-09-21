package com.rookie.player.domain;

import com.rookie.league.domain.LeagueId;
import com.rookie.league.domain.LeagueIdMother;
import com.rookie.player.application.create.CreatePlayerCommand;
import com.rookie.user.domain.UserId;
import com.rookie.user.domain.UserIdMother;

public class PlayerMother {
    public static Player create(PlayerId  id, UserId userId, LeagueId leagueId){
        return new Player(id, userId, leagueId);
    }
    public static Player random(){
        return create(PlayerIdMother.random(), UserIdMother.random(), LeagueIdMother.random());
    }
    public static Player fromRequest(CreatePlayerCommand request) {
		return create(PlayerIdMother.create(request.id()), 
					  UserIdMother.create(request.userId()),
					  LeagueIdMother.create(request.leagueId()));
	  }    
}
