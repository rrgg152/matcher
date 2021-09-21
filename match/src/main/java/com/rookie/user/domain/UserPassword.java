package com.rookie.user.domain;

import com.rookie.shared.domain.StringValueObject;


public final class UserPassword extends StringValueObject{

	public UserPassword(String value) {
		super(value);
	}

	public UserPassword() {
		super("");
	}
}
