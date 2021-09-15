package com.rookie.shared.domain.bus.query.error;

import com.rookie.shared.domain.error.DomainError;

public final class QueryHandlerExecutionError extends DomainError {
    public QueryHandlerExecutionError(Throwable cause) {
        super("QueryHandlerExecutionError", cause.getMessage());
    }
}