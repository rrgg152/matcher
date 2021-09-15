package com.rookie.user.application.find;

import com.rookie.shared.domain.Handdler;
import com.rookie.shared.domain.bus.query.QueryHandler;
import com.rookie.user.application.UserResponse;
import com.rookie.user.domain.error.UserNotExist;

@Handdler
public final class FindUserQueryHandler implements QueryHandler<FindUserQuery, UserResponse> {
    private final UserFinder finder;

    public FindUserQueryHandler(UserFinder finder) {
        this.finder = finder;
    }

    @Override
    public UserResponse handle(FindUserQuery query) throws UserNotExist {
        return finder.find(query.id());
    }
}