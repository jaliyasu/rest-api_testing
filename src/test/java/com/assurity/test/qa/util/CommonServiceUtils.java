package com.assurity.test.qa.util;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility Class
 *
 * @author Jaliya Sumanadasa
 */

@Service("commonServiceUtils")
public class CommonServiceUtils {


    @Autowired
    private ObjectMapper objectMapper;


    private static final Logger LOGGER = LoggerFactory.getLogger(CommonServiceUtils.class);

    /**
     * Build Header for requests.
     *
     * @param Map<String ,String> header key and value pair
     * @return Map<String                                                               ,                                                                                                                               String>
     */
    public Map<String, String> setAPIHeaders(Map<String, String> headerSet) {

        Map<String, String> headers = new HashMap<String, String>();
        addDefaultHeaders(headers);
        headerSet.forEach((k, v) -> {
            headers.put(k, v);
        });

        return headers;
    }


    /**
     * Inserts the value to the url.
     *
     * @param url:   The url
     * @param value: The value to be inserted
     * @return Completed Url String
     */
    public String buildUrl(String url, String value) {
        return MessageFormat.format(url, value);
    }

    private void addDefaultHeaders(Map<String, String> headers) {
        headers.put(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.put(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.name());


    }




}
