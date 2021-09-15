package com.rookie.user;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;

import com.rookie.shared.infrastructure.UnitTestCase;
import com.rookie.user.domain.User;
import com.rookie.user.domain.UserRepository;

public abstract class UserModuleUnitTestCase extends UnitTestCase {
    protected UserRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(UserRepository.class);
    }

    public void shouldHaveSaved(User course) {
        verify(repository, atLeastOnce()).save(course);
    }
}