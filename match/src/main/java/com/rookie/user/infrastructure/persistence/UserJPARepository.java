package com.rookie.user.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rookie.user.domain.User;
import com.rookie.user.domain.UserId;

@Repository
public interface UserJPARepository extends CrudRepository<User, UserId>{

}
