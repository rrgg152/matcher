package com.rookie.user.infrastructure.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rookie.shared.domain.ApiController;
import com.rookie.shared.domain.bus.command.CommandBus;
import com.rookie.shared.domain.bus.query.QueryBus;
import com.rookie.shared.domain.bus.query.error.QueryHandlerExecutionError;
import com.rookie.shared.domain.error.DomainError;
import com.rookie.shared.infrastructure.HttpResponse;
import com.rookie.user.application.UserResponse;
import com.rookie.user.application.find.FindUserQuery;
import com.rookie.user.domain.error.UserNotExist;

import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class UserDetailGetController extends ApiController{

    public UserDetailGetController(
            QueryBus queryBus,
            CommandBus commandBus
        ) {
            super(queryBus, commandBus);
        }

        @GetMapping("/users/{id}")
        public ResponseEntity<HttpResponse> index(@Schema(example = "a7f16aa2-158d-11ec-82a8-0242ac130003", required = true) @PathVariable String id) throws QueryHandlerExecutionError {
            UserResponse user = ask(new FindUserQuery(id));

            return new ResponseEntity<>(HttpResponse.responseOk(HttpStatus.OK.value(), user.toCollection()), HttpStatus.OK);
        }

        @Override
        public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
            return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
                put(UserNotExist.class, HttpStatus.NOT_FOUND);
            }};
        }
}
