package com.rookie.user.application;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((nick == null) ? 0 : nick.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserResponse other = (UserResponse) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (nick == null) {
            if (other.nick != null)
                return false;
        } else if (!nick.equals(other.nick))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

        
}