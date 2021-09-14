package com.rookie.shared.infrastructure.bus.query;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.rookie.shared.domain.bus.query.Query;
import com.rookie.shared.domain.bus.query.QueryBus;
import com.rookie.shared.domain.bus.query.QueryHandler;
import com.rookie.shared.domain.bus.query.Response;
import com.rookie.shared.domain.bus.query.error.QueryHandlerExecutionError;

@Service
public final class InMemoryQueryBus implements QueryBus {
    private final QueryHandlersInformation information;
    private final ApplicationContext       context;

    public InMemoryQueryBus(QueryHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public Response ask(Query query) throws QueryHandlerExecutionError {
        try {
            Class<? extends QueryHandler> queryHandlerClass = information.search(query.getClass());

            QueryHandler handler = context.getBean(queryHandlerClass);

            return handler.handle(query);
        } catch (Throwable error) {
            throw new QueryHandlerExecutionError(error);
        }
    }
}