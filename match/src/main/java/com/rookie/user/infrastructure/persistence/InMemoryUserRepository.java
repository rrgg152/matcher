package com.rookie.user.infrastructure.persistence;

import java.util.HashMap;
import java.util.Optional;

import com.rookie.user.domain.User;
import com.rookie.user.domain.UserId;
import com.rookie.user.domain.UserRepository;

public class InMemoryUserRepository implements UserRepository {

    private HashMap<String, User> users = new HashMap<>();
    @Override
    public Optional<User> byId(UserId id) {
        return Optional.ofNullable(users.get(id.value()));
    }

    @Override
    public void save(User user) {
        users.put(user.id().value(), user);
    }
    
}
