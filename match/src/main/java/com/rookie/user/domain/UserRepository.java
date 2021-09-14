package com.rookie.user.domain;

import java.util.Optional;

public interface UserRepository {

	Optional<User> byId(UserId id);
	
	void save(User user);
}
