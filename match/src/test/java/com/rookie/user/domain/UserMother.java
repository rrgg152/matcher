package com.rookie.user.domain;

import com.rookie.user.application.create.CreateUserCommand;

public class UserMother {

	  public static User create(UserId id, UserName name, UserNick nick, UserPassword password) {
	    return new User(id, name, nick, password);
	  }

	  public static User fromRequest(CreateUserCommand request) {
		return create(UserIdMother.create(request.id()), 
					  UserNameMother.create(request.name()),
					  UserNickMother.create(request.nick()), 
					  UserPasswordMother.create(request.password()));
	  }
	  public static User random() {
		return create(UserIdMother.random(), 
					  UserNameMother.random(), 
					  UserNickMother.random(),
					  UserPasswordMother.random());
	  }

}
