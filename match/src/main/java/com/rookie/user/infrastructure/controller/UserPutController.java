package com.rookie.user.infrastructure.controller;

import java.util.HashMap;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rookie.shared.domain.ApiController;
import com.rookie.shared.domain.bus.command.CommandBus;
import com.rookie.shared.domain.bus.command.error.CommandHandlerExecutionError;
import com.rookie.shared.domain.bus.query.QueryBus;
import com.rookie.shared.domain.error.DomainError;
import com.rookie.user.application.create.CreateUserCommand;

import io.swagger.v3.oas.annotations.media.Schema;


@RestController
public final class UserPutController extends ApiController {

	public UserPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}
	@PutMapping(value="/users/{id}")
	public ResponseEntity<String> __invoke(@Schema(description = "user identifier", example = "7799d098-9f48-4e1d-a8bc-35c2cb173a45", required = true) @PathVariable String id, @RequestBody Request request) throws CommandHandlerExecutionError {
		
	        dispatch(new CreateUserCommand(id, request.getName(), request.getNick(), "password"));

	        return new ResponseEntity<>(HttpStatus.CREATED);
	    }
	
	
	
	
	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {        
		return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
    }};}

}
final class Request {
	
	@Schema(description = "Name of user", example = "Gotxo", required = true)
    private String name;
	@Schema(description = "nick for login", example = "user", required = true)
    private String nick;
    
	public Request(String name, String nick) {
		super();
		this.name = name;
		this.nick = nick;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}


}