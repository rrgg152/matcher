package com.rookie.user.domain;

import com.rookie.shared.domain.UuidMother;

public class UserIdMother {

	public static UserId create(String value) {
		return new UserId(value);
	}
	public static UserId random() {
		return create(UuidMother.random());
	}
}