package com.rookie.shared.infrastructure;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.rookie.MatchApplication;

@SpringBootTest
@ContextConfiguration(
    classes = MatchApplication.class
)
public abstract class InfrastructureTestCase {

}
