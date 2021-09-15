package com.rookie.user;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

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

    public void shouldHaveSaved(User user) {
        verify(repository, atLeastOnce()).save(user);
    }
    
    public void shouldSearch(User user, UserRepository repo) {
        Mockito.when(repo.byId(user.id())).thenReturn(Optional.of(user));
    }
}