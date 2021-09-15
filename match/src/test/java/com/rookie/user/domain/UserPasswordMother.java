package com.rookie.user.domain;

import com.rookie.shared.domain.WordMother;

public class UserPasswordMother {

	public static UserPassword create(String value) {
		return new UserPassword(value);
	}
	public static UserPassword random() {
		return create(WordMother.random());
	}
}