package com.assurity.test.qa.util;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;



/**
 *  authentication verification for user
 *  Prior access validation before access REST url
 * 
 * @author Jaliya Sumanadsa
 *
 */
@Component("sysToSysPITokenGenerator")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@PropertySource(value = { "classpath:/application.properties",
	"classpath:${ENV:}/environment.properties" })
public class AuthorizeTokenGenerator {

    private static final Logger logger = LoggerFactory
	    .getLogger(AuthorizeTokenGenerator.class);


   public Map<String,String> getCommonHeader(){

       Map<String, String> header = new HashMap<String, String>();

       header.put(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
       header.put(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.name());


       return header;
   }
}
