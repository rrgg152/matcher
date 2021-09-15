package com.rookie.player.domain;

import com.rookie.shared.domain.UuidMother;

public class PlayerUserIdMother {
    public static PlayerUserId create(String value){
        return new PlayerUserId(value);
    }
    public static PlayerUserId random(){
        return create(UuidMother.random());
    }
}
