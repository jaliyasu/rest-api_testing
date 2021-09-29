package com.assurity.test.qa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;


/**
 * Configuration File.
 * 
 * @author Jaliya Sumanadasa
 *
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    private static final String SPRING_HATEOAS_OBJECT_MAPPER = "_halObjectMapper";

    //@Autowired
    @Qualifier(SPRING_HATEOAS_OBJECT_MAPPER)
    private ObjectMapper springHateoasObjectMapper=new ObjectMapper();


    @Bean(name = "objectMapper")
    public ObjectMapper objectMapper() {
	springHateoasObjectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	springHateoasObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	springHateoasObjectMapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
	springHateoasObjectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
	springHateoasObjectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	springHateoasObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	return springHateoasObjectMapper;
    }

}
