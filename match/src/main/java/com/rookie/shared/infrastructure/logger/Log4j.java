package com.rookie.shared.infrastructure.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class Log4j implements com.rookie.shared.domain.log.Logger {

	Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public void info(String message) {
		logger.info(message);
		
	}

	@Override
	public void critical(String message) {
		logger.error(message);
	}

	

}
