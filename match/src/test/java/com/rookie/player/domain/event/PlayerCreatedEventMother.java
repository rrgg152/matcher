package com.rookie.player.domain.event;

import com.rookie.player.domain.Player;
import com.rookie.player.domain.PlayerId;
import com.rookie.player.domain.PlayerIdMother;
import com.rookie.player.domain.PlayerLeagueId;
import com.rookie.player.domain.PlayerLeagueIdMother;
import com.rookie.player.domain.PlayerUserId;
import com.rookie.player.domain.PlayerUserIdMother;

public class PlayerCreatedEventMother {

    public static PlayerCreatedEvent create(PlayerId id, PlayerUserId userId, PlayerLeagueId leagueId) {
          return new PlayerCreatedEvent(id, userId, leagueId);
        }
    
    public static PlayerCreatedEvent fromPlayer(Player player) {
        return create(player.id(), player.userId(), player.leagueId());
    }
    
    public static PlayerCreatedEvent random() {
        return create(PlayerIdMother.random(), PlayerUserIdMother.random(), PlayerLeagueIdMother.random());
    }
    

    
}
