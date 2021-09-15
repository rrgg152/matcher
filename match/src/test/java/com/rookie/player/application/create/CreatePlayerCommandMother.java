package com.rookie.player.application.create;

import com.rookie.player.domain.PlayerId;
import com.rookie.player.domain.PlayerIdMother;
import com.rookie.player.domain.PlayerLeagueId;
import com.rookie.player.domain.PlayerLeagueIdMother;
import com.rookie.player.domain.PlayerUserId;
import com.rookie.player.domain.PlayerUserIdMother;

public final class CreatePlayerCommandMother {
	
    public static CreatePlayerCommand create(PlayerId id, PlayerUserId userId, PlayerLeagueId leagueId) {
        return new CreatePlayerCommand(id.value(), userId.value(), leagueId.value());
    }

    public static CreatePlayerCommand random() {
        return create(PlayerIdMother.random(), PlayerUserIdMother.random(), PlayerLeagueIdMother.random());
    }
}