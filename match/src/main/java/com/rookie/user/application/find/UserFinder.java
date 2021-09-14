package com.rookie.user.application.find;

import com.rookie.shared.domain.ApplicationService;
import com.rookie.user.application.UserResponse;
import com.rookie.user.domain.UserId;
import com.rookie.user.domain.UserRepository;
import com.rookie.user.domain.error.UserNotExist;

@ApplicationService
public class UserFinder {

	private final UserRepository repo;

	public UserFinder(UserRepository repo) {
		super();
		this.repo = repo;
	}
	
	public UserResponse find (String idrequest) {
		
		UserId id = new UserId(idrequest);
		return repo.byId(id)
		.map(UserResponse::fromDomain)
		.orElseThrow(() -> new UserNotExist(id));
	}
}
