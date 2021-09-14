package com.rookie.shared.domain.bus.query;

import com.rookie.shared.domain.bus.query.error.QueryHandlerExecutionError;

public interface QueryBus {
    <R> R ask(Query query) throws QueryHandlerExecutionError;
}
