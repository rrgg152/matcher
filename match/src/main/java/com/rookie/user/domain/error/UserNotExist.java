package com.rookie.user.domain.error;

import com.rookie.shared.domain.error.DomainError;
import com.rookie.user.domain.UserId;

public final class UserNotExist extends DomainError {
    public UserNotExist(UserId id) {
        super("user_not_exist", String.format("The user <%s> doesn't exist", id.value()));
    }
}