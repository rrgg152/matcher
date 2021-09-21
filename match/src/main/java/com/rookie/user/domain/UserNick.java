package com.rookie.user.domain;

import com.rookie.shared.domain.StringValueObject;

public final class UserNick extends  StringValueObject{

	public UserNick(String value) {
		super(value);
	}

	public UserNick() {
		super("");
	}	
}
