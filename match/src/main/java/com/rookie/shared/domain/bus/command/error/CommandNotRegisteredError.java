package com.rookie.shared.domain.bus.command.error;

import com.rookie.shared.domain.bus.command.Command;

public final class CommandNotRegisteredError extends Exception {
    public CommandNotRegisteredError(Class<? extends Command> command) {
        super(String.format("The command <%s> hasn't a command handler associated", command.toString()));
    }
}