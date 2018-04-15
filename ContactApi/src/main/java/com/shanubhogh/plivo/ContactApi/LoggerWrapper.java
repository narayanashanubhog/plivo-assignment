package com.shanubhogh.plivo.ContactApi;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerWrapper extends Logger {

	static String FQCN = LoggerWrapper.class.getName();

	private Logger logger;

	public LoggerWrapper(String name) {
		super(name);
		this.logger = Logger.getLogger(name);
	}

	public LoggerWrapper(Class<?> clazz) {
		this(clazz.getName());
	}

	public void info(Object message) {
		logger.log(FQCN, Level.INFO, message, null);
	}

	public void info(Object message, Throwable t) {
		logger.log(FQCN, Level.INFO, message, t);
	}

	public void error(Object message) {
		logger.log(FQCN, Level.ERROR, message, null);
	}

	public void error(Object message, Throwable t) {
		logger.log(FQCN, Level.ERROR, message, t);
	}

	public void warn(Object message) {
		logger.log(FQCN, Level.WARN, message, null);
	}
}
