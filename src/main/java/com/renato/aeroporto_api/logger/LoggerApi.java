package com.renato.aeroporto_api.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerApi {
    private static final Logger logger = LoggerFactory.getLogger(LoggerApi.class);

    public static void logRequest(String request) {
        logger.info(request);
    }

    public static void logRequestDetails(String details) {
        logger.debug(details);
    }

    public static void logDatabaseDetails(String details) {
        logger.debug(details);
    }

    public static void logDatabaseError(String errors) {
        logger.error(errors.toUpperCase());
    }

    public static void logRequestError(String errors) {
        logger.error(errors.toUpperCase());
    }

    public static void logInternalError(String error){
        logger.error(error.toUpperCase());
    }
}