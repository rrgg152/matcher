package com.rookie.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.rookie.shared.infrastructure.InfrastructureTestCase;
import com.rookie.user.domain.UserRepository;

public abstract class UserModuleInfrastructureTestCase
    extends InfrastructureTestCase {

  @Autowired
  protected UserRepository userRepository;
}
