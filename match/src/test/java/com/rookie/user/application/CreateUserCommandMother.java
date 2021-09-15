package com.rookie.user.application;

import com.rookie.user.application.create.CreateUserCommand;
import com.rookie.user.domain.UserId;
import com.rookie.user.domain.UserIdMother;
import com.rookie.user.domain.UserName;
import com.rookie.user.domain.UserNameMother;
import com.rookie.user.domain.UserNick;
import com.rookie.user.domain.UserNickMother;
import com.rookie.user.domain.UserPassword;
import com.rookie.user.domain.UserPasswordMother;

public final class CreateUserCommandMother {
	
    public static CreateUserCommand create(UserId id, UserName name, UserNick nick, UserPassword password) {
        return new CreateUserCommand(id.value(), name.value(), nick.value(), password.value());
    }

    public static CreateUserCommand random() {
        return create(UserIdMother.random(), UserNameMother.random(), UserNickMother.random(), UserPasswordMother.random());
    }
}