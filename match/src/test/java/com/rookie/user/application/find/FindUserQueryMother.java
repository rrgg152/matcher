package com.rookie.user.application.find;

import com.rookie.user.domain.UserId;
import com.rookie.user.domain.UserIdMother;

public final class FindUserQueryMother {
	
    public static FindUserQuery create(UserId id) {
        return new FindUserQuery(id.value());
    }

    public static FindUserQuery random() {
        return create(UserIdMother.random());
    }
}