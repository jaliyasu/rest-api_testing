package com.assurity.test.qa;

import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Product Features Integration Tests.
 *
 * ${ENV:} -User can specify the environment need to execute against
 *              available environments - local,qa,prd,stg,prd
 * 
 * @author Jaliya Sumanadasa
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {
	"src/test/resources/cucumber/feature/" }, tags = { "@BVT" }, plugin = {
	"html:target/cucumber-html-report", "json:target/cucumber-json-report.json",
	"junit:target/cucumber-json-report.xml" })
@PropertySource(value = { "classpath:/application.properties", "classpath:${ENV:}/environment.properties" })
public class BvtTests {

}
