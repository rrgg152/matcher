package com.rookie.user.application;

import com.rookie.shared.domain.UuidMother;
import com.rookie.shared.domain.WordMother;

public class UserResponseMother {
    public static UserResponse create(String id, String name, String nick, String password){
        return new UserResponse(id, name, nick, password);
    }

    public static UserResponse random(){
        return create(UuidMother.random(), WordMother.random(), WordMother.random(), WordMother.random());
    }
}
