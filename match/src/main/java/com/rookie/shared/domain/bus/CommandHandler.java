package com.rookie.shared.domain.bus;

import com.rookie.shared.domain.bus.command.Command;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}
