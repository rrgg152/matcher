package com.rookie.user.application.find;

import static org.junit.Assert.assertEquals;

import com.rookie.user.UserModuleUnitTestCase;
import com.rookie.user.application.UserResponse;
import com.rookie.user.application.UserResponseMother;
import com.rookie.user.application.create.UserCreator;
import com.rookie.user.domain.User;
import com.rookie.user.domain.UserMother;
import com.rookie.user.infrastructure.persistence.InMemoryUserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindUserQueryHandlerShould extends UserModuleUnitTestCase  {
    private FindUserQueryHandler handler;
    private InMemoryUserRepository inMemoryRepo;
    private UserCreator creator;
    @BeforeEach
    protected void setUp() {
        super.setUp();
        inMemoryRepo   = new InMemoryUserRepository();
        handler        = new FindUserQueryHandler(new UserFinder(inMemoryRepo));
        creator        = new UserCreator(eventBus, inMemoryRepo);
    }

    
    @Test
    void not_find_an_existing_user() {
        
        User      user      = UserMother.random();

        creator.execute(user.id(), user.name(), user.nick(), user.password());

        FindUserQuery query = FindUserQueryMother.create(user.id());
        UserResponse response = UserResponseMother.create(user.id().value(), user.name().value(), user.nick().value(), user.password().value());

        assertEquals(response, handler.handle(query));
    }

}
