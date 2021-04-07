package com.app.logging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface BaseLoggers {
    public static final Logger eventLogger = LoggerFactory.getLogger("com.app.event");


    public static final Logger flowLogger = LoggerFactory.getLogger("com.app.control");


    public static final Logger exceptionLogger = LoggerFactory.getLogger("com.app.exception");


    public static final Logger persistenceLogger = LoggerFactory.getLogger("com.app.persistence");


    public static final Logger workflowLogger = LoggerFactory.getLogger("com.app.workflow");


    public static final Logger securityLogger = LoggerFactory.getLogger("com.app.security");


    public static final Logger performanceLogger = LoggerFactory.getLogger("com.app.performance");


    public static final Logger webLogger = LoggerFactory.getLogger("com.app.web");


    public static final Logger accessLogger = LoggerFactory.getLogger("com.app.access");


    public static final Logger productInfoLogger = LoggerFactory.getLogger("com.app.product.info");


    public static final Logger bugLogger = LoggerFactory.getLogger("com.app.bug");


    public static final Logger integrationLogger = LoggerFactory.getLogger("com.app.integration");


    public static final Logger apiManagementLogger = LoggerFactory.getLogger("com.app.control");


    public static final Logger quartzJobLogger = LoggerFactory.getLogger("com.app.core.scheduler");

    public static final Logger creditBureauGenericLogger = 
            LoggerFactory.getLogger("com.app.creditBureau.generic");

    public static final Logger conversationalLogger = 
            LoggerFactory.getLogger("com.app.conversation");

    public static final Logger masterDataLogger = LoggerFactory.getLogger("com.app.makerchecker.GridDataUtility");
}



