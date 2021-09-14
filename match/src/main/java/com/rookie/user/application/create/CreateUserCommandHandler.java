package com.rookie.user.application.create;

import com.rookie.shared.domain.Handdler;
import com.rookie.shared.domain.bus.CommandHandler;
import com.rookie.user.domain.UserId;
import com.rookie.user.domain.UserName;
import com.rookie.user.domain.UserNick;
import com.rookie.user.domain.UserPassword;

@Handdler
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand>{

	private final UserCreator creator;
	
	
	public CreateUserCommandHandler(UserCreator creator) {
		super();
		this.creator = creator;
	}


	@Override
	public void handle(CreateUserCommand command) {
		UserId id = new UserId(command.id());
		UserName name = new UserName(command.name());
		UserPassword password = new UserPassword(command.password());
		UserNick nick = new UserNick(command.nick());
		creator.execute(id, name, nick, password);
	}

}
