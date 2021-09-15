package com.rookie.user.domain;

import com.rookie.shared.domain.WordMother;

public class UserNameMother {

	public static UserName create(String value) {
		return new UserName(value);
	}
	public static UserName random() {
		return create(WordMother.random());
	}
}