package com.rookie.user.application.create;

import com.rookie.shared.domain.ApplicationService;
import com.rookie.shared.domain.bus.event.EventBus;
import com.rookie.user.domain.User;
import com.rookie.user.domain.UserId;
import com.rookie.user.domain.UserName;
import com.rookie.user.domain.UserNick;
import com.rookie.user.domain.UserPassword;
import com.rookie.user.domain.UserRepository;

@ApplicationService
public class UserCreator {

	public final EventBus bus;
	public final UserRepository repo;
	
	
	public UserCreator(EventBus bus, UserRepository repo) {
		super();
		this.bus = bus;
		this.repo = repo;
	}


	public void execute(UserId id, UserName name, UserNick nick, UserPassword password) {
		User user = User.ceate(id, name, nick, password);
		repo.save(user);
		bus.publish(user.pullDomainEvents());
	}

}
