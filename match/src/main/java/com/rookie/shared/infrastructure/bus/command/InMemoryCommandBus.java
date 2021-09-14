package com.rookie.shared.infrastructure.bus.command;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.rookie.shared.domain.bus.CommandHandler;
import com.rookie.shared.domain.bus.command.Command;
import com.rookie.shared.domain.bus.command.CommandBus;
import com.rookie.shared.domain.bus.command.error.CommandHandlerExecutionError;

@Service
public final class InMemoryCommandBus implements CommandBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext         context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionError {
        try {
            Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

            CommandHandler handler = context.getBean(commandHandlerClass);

            handler.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionError(error);
        }
    }
}