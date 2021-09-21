package com.rookie.player.application.create;

import com.rookie.league.domain.LeagueId;
import com.rookie.player.domain.Player;
import com.rookie.player.domain.PlayerId;
import com.rookie.player.domain.PlayerRepository;
import com.rookie.shared.domain.ApplicationService;
import com.rookie.shared.domain.bus.event.EventBus;
import com.rookie.user.domain.UserId;

@ApplicationService
public class PlayerCreator {

	public final EventBus bus;
	public final PlayerRepository repo;
	
	
	public PlayerCreator(EventBus bus, PlayerRepository repo) {
		super();
		this.bus = bus;
		this.repo = repo;
	}


	public void execute(PlayerId id, UserId userId, LeagueId leagueId) {
		Player user = Player.create(id, userId, leagueId);
		repo.save(user);
		bus.publish(user.pullDomainEvents());
	}

}
