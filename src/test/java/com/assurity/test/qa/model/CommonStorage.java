package com.assurity.test.qa.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Singleton class to share  information between the Tests.
 *
 *
 *@author Jaliya Sumanadasa
 */
@Component("commonStorage")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CommonStorage {

    /* General Request Information. */

    private ResponseEntity<String> responseObject;



    public ResponseEntity<String> getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(ResponseEntity<String> responseObject) {
        this.responseObject = responseObject;
    }



}
