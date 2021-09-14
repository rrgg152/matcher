package com.rookie.shared.domain.bus.query;

import java.util.Collection;

public interface Response {
	
	Collection<?> toCollection();
}