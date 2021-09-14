package com.rookie.user.application.find;

import com.rookie.shared.domain.bus.query.Query;

public final class FindUserQuery implements Query {

	private final String id;

	public FindUserQuery(String id) {
		super();
		this.id = id;
	}

	public String id() {
		return id;
	}
	
}
