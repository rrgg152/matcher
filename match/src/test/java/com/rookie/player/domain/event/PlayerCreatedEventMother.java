package com.rookie.player.domain.event;

import com.rookie.league.domain.LeagueId;
import com.rookie.league.domain.LeagueIdMother;
import com.rookie.player.domain.Player;
import com.rookie.player.domain.PlayerId;
import com.rookie.player.domain.PlayerIdMother;
import com.rookie.user.domain.UserId;
import com.rookie.user.domain.UserIdMother;

public class PlayerCreatedEventMother {

    public static PlayerCreatedEvent create(PlayerId id, UserId userId, LeagueId leagueId) {
          return new PlayerCreatedEvent(id, userId, leagueId);
        }
    
    public static PlayerCreatedEvent fromPlayer(Player player) {
        return create(player.id(), player.userId(), player.leagueId());
    }
    
    public static PlayerCreatedEvent random() {
        return create(PlayerIdMother.random(), UserIdMother.random(), LeagueIdMother.random());
    }
    

    
}
