package com.rookie.player;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import com.rookie.player.domain.Player;
import com.rookie.player.domain.PlayerRepository;
import com.rookie.shared.infrastructure.UnitTestCase;
import com.rookie.user.domain.User;
import com.rookie.user.domain.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public abstract class PlayerModuleUnitTestCase extends UnitTestCase {
    protected PlayerRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(PlayerRepository.class);
    }

    public void shouldHaveSaved(Player player) {
        verify(repository, atLeastOnce()).save(player);
    }
    
    public void shouldSearch(User user, UserRepository repo) {
        Mockito.when(repo.byId(user.id())).thenReturn(Optional.of(user));
    }
}