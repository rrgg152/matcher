package com.rookie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.rookie.shared.domain.ApplicationService;
import com.rookie.shared.domain.Handdler;

@SpringBootApplication
@ComponentScan(
	    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {ApplicationService.class, Handdler.class}),
	    value = {"com.rookie"}
	)
public class MatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchApplication.class, args);
	}

}
