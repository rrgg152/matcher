package com.rookie.user.infrastructure.persistence;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import com.rookie.user.UserModuleInfrastructureTestCase;
import com.rookie.user.domain.User;
import com.rookie.user.domain.UserIdMother;
import com.rookie.user.domain.UserMother;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
public class H2UserRepositoryShould extends UserModuleInfrastructureTestCase {

    @Test
    void save_an_user() {
        User user = UserMother.random();

        userRepository.save(user);
    }
    @Test
    void return_an_user_existing_user() {

        User user = UserMother.random();

        userRepository.save(user);
        assertEquals(Optional.of(user), userRepository.byId(user.id()));
    }

    @Test
    void not_find_a_non_existing_user() {
        assertFalse(userRepository.byId(UserIdMother.random()).isPresent());
    }
}
