package com.rookie.player.application.create;

import com.rookie.league.domain.LeagueId;
import com.rookie.league.domain.LeagueIdMother;
import com.rookie.player.domain.PlayerId;
import com.rookie.player.domain.PlayerIdMother;
import com.rookie.user.domain.UserId;
import com.rookie.user.domain.UserIdMother;

public final class CreatePlayerCommandMother {
	
    public static CreatePlayerCommand create(PlayerId id, UserId userId, LeagueId leagueId) {
        return new CreatePlayerCommand(id.value(), userId.value(), leagueId.value());
    }

    public static CreatePlayerCommand random() {
        return create(PlayerIdMother.random(), UserIdMother.random(), LeagueIdMother.random());
    }
}