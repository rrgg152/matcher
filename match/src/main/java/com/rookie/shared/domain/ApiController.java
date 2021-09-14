package com.rookie.shared.domain;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

import com.rookie.shared.domain.bus.command.Command;
import com.rookie.shared.domain.bus.command.CommandBus;
import com.rookie.shared.domain.bus.command.error.CommandHandlerExecutionError;
import com.rookie.shared.domain.bus.query.Query;
import com.rookie.shared.domain.bus.query.QueryBus;
import com.rookie.shared.domain.bus.query.error.QueryHandlerExecutionError;
import com.rookie.shared.domain.error.DomainError;

public abstract class ApiController {
    private final QueryBus   queryBus;
    private final CommandBus commandBus;

    public ApiController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus   = queryBus;
        this.commandBus = commandBus;
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionError {
        commandBus.dispatch(command);
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionError {
        return queryBus.ask(query);
    }

    abstract public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();
}
