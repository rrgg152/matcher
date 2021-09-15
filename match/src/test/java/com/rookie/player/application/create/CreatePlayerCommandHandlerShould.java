package com.rookie.player.application.create;
import static org.mockito.Mockito.mock;

import com.rookie.player.PlayerModuleUnitTestCase;
import com.rookie.player.domain.Player;
import com.rookie.player.domain.PlayerMother;
import com.rookie.player.domain.event.PlayerCreatedEvent;
import com.rookie.player.domain.event.PlayerCreatedEventMother;
import com.rookie.shared.domain.bus.query.QueryBus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class CreatePlayerCommandHandlerShould extends PlayerModuleUnitTestCase {
    private CreatePlayerCommandHandler handler;
    private QueryBus queryBus;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        queryBus = mock(QueryBus.class) ;
        handler = new CreatePlayerCommandHandler(new PlayerCreator(eventBus, repository), queryBus);
    }

    @Test
    void create_a_valid_player() {
        CreatePlayerCommand command = CreatePlayerCommandMother.random();

        Player             player      = PlayerMother.fromRequest(command);
        PlayerCreatedEvent domainEvent = PlayerCreatedEventMother.fromPlayer(player);

        handler.handle(command);

        shouldHaveSaved(player);

        shouldHavePublished(domainEvent);
    }
}