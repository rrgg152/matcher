package com.rookie.user.domain;

import com.rookie.shared.domain.StringValueObject;

public final class UserName extends StringValueObject{

	public UserName(String value) {
		super(value);
	}
	protected UserName() {
		super("");
	}
}
