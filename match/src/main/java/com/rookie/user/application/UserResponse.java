package com.rookie.user.application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rookie.shared.domain.bus.query.Response;
import com.rookie.user.domain.User;

public final class UserResponse implements Response {
    private final String id;
    private final String name;
    private final String nick;
    private final String password;



    public UserResponse(String id, String name, String nick, String password) {
		super();
		this.id = id;
		this.name = name;
		this.nick = nick;
		this.password = password;
	}

	public static UserResponse fromDomain(User user) {
        return new UserResponse(user.id().value(), user.name().value(), user.nick().value(), user.password().value());
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String nick() {
        return nick;
    }
    public String password() {
        return password;
    }

	@Override
	public Collection<?> toCollection() {
		List<Map<String, Object>> bodyResponse = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> bodyPart = new HashMap<>();
		bodyPart.put(User.ID, id());
		bodyPart.put(User.NAME, name());
		bodyPart.put(User.NICK, nick());
		bodyPart.put(User.PASSWORD, password());
		bodyResponse.add(bodyPart);
		
		return bodyResponse;}
}