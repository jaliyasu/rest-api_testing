package com.assurity.test.qa;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootContextLoader;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.assurity.test.qa.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = TestApplication.class, loader = SpringBootContextLoader.class)
//@IntegrationTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public @interface CucumberStepsDefinition {

}