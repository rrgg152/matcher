package com.rookie.user.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.rookie.user.domain.User;
import com.rookie.user.domain.UserId;
import com.rookie.user.domain.UserRepository;
@Repository
public class H2UserRepository implements UserRepository{

	private final UserJPARepository repo;
	
	
	public H2UserRepository(UserJPARepository repo) {
		super();
		this.repo = repo;
	}


	@Override
	public Optional<User> byId(UserId id) {
		return repo.findById(id.value());
	}


	@Override
	public void save(User user) {
		repo.save(user);
	}

}
