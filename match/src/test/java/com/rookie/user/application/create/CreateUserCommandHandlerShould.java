package com.rookie.user.application.create;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rookie.user.UserModuleUnitTestCase;
import com.rookie.user.domain.User;
import com.rookie.user.domain.UserMother;
import com.rookie.user.domain.event.UserCreatedEvent;
import com.rookie.user.domain.event.UserCreatedEventMother;

final class CreateUserCommandHandlerShould extends UserModuleUnitTestCase {
    private CreateUserCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new CreateUserCommandHandler(new UserCreator(eventBus, repository));
    }

    @Test
    void create_a_valid_user() {
        CreateUserCommand command = CreateUserCommandMother.random();

        User                   user      = UserMother.fromRequest(command);
        UserCreatedEvent domainEvent = UserCreatedEventMother.fromUser(user);

        handler.handle(command);

        shouldHaveSaved(user);
        shouldHavePublished(domainEvent);
    }
}