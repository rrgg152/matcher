package com.rookie.shared.domain.bus.command;

import com.rookie.shared.domain.bus.command.error.CommandHandlerExecutionError;

public interface CommandBus {

    void dispatch(Command command) throws CommandHandlerExecutionError;
}
