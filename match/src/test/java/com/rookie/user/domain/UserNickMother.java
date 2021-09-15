package com.rookie.user.domain;

import com.rookie.shared.domain.WordMother;

public class UserNickMother {

	public static UserNick create(String value) {
		return new UserNick(value);
	}
	public static UserNick random() {
		return create(WordMother.random());
	}
}