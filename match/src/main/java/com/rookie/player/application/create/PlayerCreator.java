package com.rookie.player.application.create;

import com.rookie.player.domain.Player;
import com.rookie.player.domain.PlayerId;
import com.rookie.player.domain.PlayerLeagueId;
import com.rookie.player.domain.PlayerRepository;
import com.rookie.player.domain.PlayerUserId;
import com.rookie.shared.domain.ApplicationService;
import com.rookie.shared.domain.bus.event.EventBus;

@ApplicationService
public class PlayerCreator {

	public final EventBus bus;
	public final PlayerRepository repo;
	
	
	public PlayerCreator(EventBus bus, PlayerRepository repo) {
		super();
		this.bus = bus;
		this.repo = repo;
	}


	public void execute(PlayerId id, PlayerUserId userId, PlayerLeagueId leagueId) {
		Player user = Player.create(id, userId, leagueId);
		repo.save(user);
		bus.publish(user.pullDomainEvents());
	}

}
