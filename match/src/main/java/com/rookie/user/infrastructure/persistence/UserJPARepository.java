package com.rookie.user.infrastructure.persistence;

import com.rookie.user.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends CrudRepository<User, String>{

}
