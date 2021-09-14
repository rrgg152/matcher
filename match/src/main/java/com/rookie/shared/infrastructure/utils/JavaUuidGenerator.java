package com.rookie.shared.infrastructure.utils;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rookie.shared.domain.UuidGenerator;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}