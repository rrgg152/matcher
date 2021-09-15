package com.rookie.user.domain.event;

import com.rookie.user.domain.User;
import com.rookie.user.domain.UserId;
import com.rookie.user.domain.UserIdMother;
import com.rookie.user.domain.UserName;
import com.rookie.user.domain.UserNameMother;
import com.rookie.user.domain.UserNick;
import com.rookie.user.domain.UserNickMother;
import com.rookie.user.domain.UserPassword;
import com.rookie.user.domain.UserPasswordMother;

public class UserCreatedEventMother {

	  public static UserCreatedEvent create(UserId id, UserName name, UserNick nick, UserPassword password) {
		    return new UserCreatedEvent(id, name, nick, password);
		  }
	  
	  public static UserCreatedEvent fromUser(User user) {
		  return create(user.id(), user.name(), user.nick(), user.password());
	  }
	  
	  public static UserCreatedEvent random() {
		  return create(UserIdMother.random(), UserNameMother.random(), UserNickMother.random(), UserPasswordMother.random());
	  }
	  
}
