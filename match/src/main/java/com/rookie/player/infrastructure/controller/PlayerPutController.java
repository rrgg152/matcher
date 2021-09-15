package com.rookie.player.infrastructure.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rookie.player.application.create.CreatePlayerCommand;
import com.rookie.shared.domain.ApiController;
import com.rookie.shared.domain.UuidGenerator;
import com.rookie.shared.domain.bus.command.CommandBus;
import com.rookie.shared.domain.bus.command.error.CommandHandlerExecutionError;
import com.rookie.shared.domain.bus.query.QueryBus;
import com.rookie.shared.domain.bus.query.error.QueryHandlerExecutionError;
import com.rookie.shared.domain.error.DomainError;
import com.rookie.user.domain.error.UserNotExist;

import io.swagger.v3.oas.annotations.media.Schema;


@RestController
public final class PlayerPutController extends ApiController {

	private final UuidGenerator generator;
	
	
	public PlayerPutController(QueryBus queryBus, CommandBus commandBus, UuidGenerator generator) {
		super(queryBus, commandBus);
		this.generator = generator;
	}




	@PostMapping(value="/users/{userId}/player")
	public ResponseEntity<String> __invoke(@Schema(example = "a7f16aa2-158d-11ec-82a8-0242ac130003", required = true) @PathVariable String userId, 
			@Schema(description = "League identifier", example = "7799d098-9f48-4e1d-a8bc-35c2cb173a45", required = true) @RequestBody CreatePlayerRequest request) throws CommandHandlerExecutionError {
		
	        dispatch(new CreatePlayerCommand(generator.generate(), userId, request.getLeagueId()));

	        return new ResponseEntity<>(HttpStatus.CREATED);
	    }
	
	
	
	
	@Override
        public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
            return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
				put(QueryHandlerExecutionError.class, HttpStatus.NOT_FOUND);
            }};
        }

}
final class CreatePlayerRequest {
	@Schema(description = "League identifier", example = "7799d098-9f48-4e1d-a8bc-35c2cb173a45", required = true)
    private String leagueId;

	public CreatePlayerRequest(String leagueId) {
		super();
		this.leagueId = leagueId;
	}

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

    
	


}