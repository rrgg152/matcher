package com.rookie.user.infrastructure.persistence;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import com.rookie.user.UserModuleInfrastructureTestCase;
import com.rookie.user.domain.User;
import com.rookie.user.domain.UserMother;

@Transactional
public class H2UserRepositoryShould extends UserModuleInfrastructureTestCase {

    @Test
    void save_an_user() {
        User user = UserMother.random();

        h2Repository.save(user);
    }
}
