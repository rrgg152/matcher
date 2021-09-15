package com.rookie.player.domain;

import com.rookie.shared.domain.UuidMother;

public class PlayerIdMother {
    public static PlayerId create(String value){
        return new PlayerId(value);
    }
    public static PlayerId random(){
        return create(UuidMother.random());
    }
}
