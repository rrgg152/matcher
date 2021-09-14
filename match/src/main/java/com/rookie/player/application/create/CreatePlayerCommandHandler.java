package com.rookie.player.application.create;

import com.rookie.player.domain.PlayerId;
import com.rookie.player.domain.PlayerLeagueId;
import com.rookie.player.domain.PlayerUserId;
import com.rookie.shared.domain.Handdler;
import com.rookie.shared.domain.bus.CommandHandler;
import com.rookie.shared.domain.bus.query.QueryBus;
import com.rookie.user.application.find.FindUserQuery;

@Handdler
public class CreatePlayerCommandHandler implements CommandHandler<CreatePlayerCommand>{

	private final PlayerCreator creator;
	private final QueryBus bus;
	


	public CreatePlayerCommandHandler(PlayerCreator creator, QueryBus bus) {
		super();
		this.creator = creator;
		this.bus = bus;
	}



	@Override
	public void handle(CreatePlayerCommand command) {
		
		validUser(command.userId());
		
		PlayerId id = new PlayerId(command.id());			
		
		PlayerUserId userId = new PlayerUserId(command.userId());
		
		PlayerLeagueId leagueId = new PlayerLeagueId(command.leagueId());
		
		creator.execute(id, userId, leagueId);
	}

	private void validUser(String userId) {
		bus.ask(new FindUserQuery(userId));
	}
}
