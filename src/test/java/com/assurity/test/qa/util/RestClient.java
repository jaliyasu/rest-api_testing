/**
 * 
 */
package com.assurity.test.qa.util;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Rest client interface.
 * 
 * @author Jaliya Sumanadasa
 *
 */
@Component("restClient")
public class RestClient {

    private static final Logger logger = Logger.getLogger(RestClient.class);


    @Autowired
	private ObjectMapper objectMapper;

    /**
     * Client method to invoke GET service request.
     * 
     * @param headerValues
     *            : The values which should be added to the header of the
     *            request.
     * 
     * @param url
     *            : The URL for the service.
     * 
     * @param queryParams
     *            : The query parameters to be set to the url.
     * 
     * 
     * @return {@link ResponseEntity}
     * 
     */
    public ResponseEntity<String> getRequest(Map<String, String> headerValues, String url,
	    Map<String, String> pathParams, Map<String, String> queryParams) {

	HttpHeaders header = new HttpHeaders();
	for (Map.Entry<String, String> entry : headerValues.entrySet()) {
	    header.add(entry.getKey(), entry.getValue());
	}

	HttpEntity<String> request = new HttpEntity<String>(header);

	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

	if (queryParams != null) {

	    for (Map.Entry<String, String> entry : queryParams.entrySet()) {
		builder.queryParam(entry.getKey(), entry.getValue());
	    }
	}

	URI buildUrl = builder.buildAndExpand(pathParams).encode().toUri();

	logger.info("GET Request: " + buildUrl.toString());

		return getNewRestTemplate().exchange(buildUrl, HttpMethod.GET, request, String.class);

    }

    /**
     * Client method to invoke a POST service request.
     * 
     * @param headerValues
     *            : The values which should be added to the header of the
     *            request.
     * 
     * @param url
     *            : The URL for the service.
     * 
     * @param body
     *            : The JSON string to added to the body.
     * 
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<String> postRequest(Map<String, String> headerValues, String url, String body) {

	HttpHeaders header = new HttpHeaders();
	for (Map.Entry<String, String> entry : headerValues.entrySet()) {
	    header.add(entry.getKey(), entry.getValue());
	}

	HttpEntity<String> request = new HttpEntity<String>(body, header);

	logger.info("POST Request: " + url);

		return getNewRestTemplate().exchange(url, HttpMethod.POST, request, String.class);

    }

    /**
     * Client method to invoke a POST service request.
     * 
     * @param headerValues
     *            : The values which should be added to the header of the
     *            request.
     * 
     * @param url
     *            : The URL for the service.
     * 
     * @param body
     *            : The JSON string to added to the body.
     * 
     * @param pathParams:
     *            Path parameter to be sent in the post.
     * 
     * 
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<String> postRequest(Map<String, String> headerValues, String url, String body,
	    Map<String, String> pathParams) {

	HttpHeaders header = new HttpHeaders();
	for (Map.Entry<String, String> entry : headerValues.entrySet()) {
	    header.add(entry.getKey(), entry.getValue());
	}

	HttpEntity<String> request = new HttpEntity<String>(body, header);

	logger.info("POST Request: " + url);

		return getNewRestTemplate().exchange(url, HttpMethod.POST, request, String.class, pathParams);

    }

    /**
     * Client method to invoke a PUT service request.
     * 
     * @param headerValues
     *            : The values which should be added to the header of the
     *            request.
     * 
     * @param url
     *            : The URL for the service.
     * 
     * @param body
     *            : The JSON string to added to the body.
     * 
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<String> putRequest(Map<String, String> headerValues, String url, String body,
	    Map<String, String> pathParams) {

	HttpHeaders header = new HttpHeaders();
	for (Map.Entry<String, String> entry : headerValues.entrySet()) {
	    header.add(entry.getKey(), entry.getValue());
	}

	HttpEntity<String> request = new HttpEntity<String>(body, header);

		return getNewRestTemplate().exchange(url, HttpMethod.PUT, request, String.class, pathParams);

    }

    /**
     * Client method to invoke a PUT service request.
     * 
     * @param headerValues:
     *            Header Values
     * 
     * @param url:
     *            URL to invoke
     * 
     * @param body:
     *            Payload for request
     * 
     * @param pathParams:
     *            The path parameter
     * 
     * @param queryParams:
     *            query parameters
     * 
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<String> putRequest(Map<String, String> headerValues, String url, String body,
	    Map<String, String> pathParams, Map<String, String> queryParams) {

	HttpHeaders header = new HttpHeaders();

	for (Map.Entry<String, String> entry : headerValues.entrySet()) {
	    header.add(entry.getKey(), entry.getValue());
	}

	HttpEntity<String> request = new HttpEntity<String>(body, header);

	if (queryParams != null) {

	    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
	    for (Map.Entry<String, String> entry : queryParams.entrySet()) {
		builder.queryParam(entry.getKey(), entry.getValue());
	    }

	    url = builder.build().toString();
	}

	logger.info("PUT Request: " + url);

		return getNewRestTemplate().exchange(url, HttpMethod.PUT, request, String.class, pathParams);

    }

    /**
     * Client method to invoke a DELETE service request.
     * 
     * @param headerValues
     *            : The values which should be added to the header of the
     *            request.
     * 
     * @param url
     *            : The URL for the service.
     * 
     * @param pathParams
     *            : The query parameters to be set to the url.
     * 
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<String> deleteRequest(Map<String, String> headerValues, String url,
	    Map<String, String> pathParams) {

	HttpHeaders header = new HttpHeaders();
	for (Map.Entry<String, String> entry : headerValues.entrySet()) {
	    header.add(entry.getKey(), entry.getValue());
	}

	HttpEntity<String> request = new HttpEntity<String>(header);

		return getNewRestTemplate().exchange(url, HttpMethod.DELETE, request, String.class, pathParams);

    }

    /**
     * Client method to invoke a PATCH service request.
     * 
     * @param headerValues
     *            : The values which should be added to the header of the
     *            request.
     * 
     * @param url
     *            : The URL for the service.
     * 
     * @param body
     *            : The JSON string to added to the body.
     * 
     * @return {@link ResponseEntity}
     */
    public ResponseEntity<String> patchRequest(Map<String, String> headerValues, String url, String body,
	    Map<String, String> pathParams) {

	HttpHeaders header = new HttpHeaders();
	for (Map.Entry<String, String> entry : headerValues.entrySet()) {
	    header.add(entry.getKey(), entry.getValue());
	}

	HttpEntity<String> request = new HttpEntity<String>(body, header);

		return getNewRestTemplate().exchange(url, HttpMethod.PATCH, request, String.class, pathParams);

    }


	public RestTemplate getNewRestTemplate() {

		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper);

		RestTemplate restTemplate = new RestTemplate(Collections.<HttpMessageConverter<?>>singletonList(converter));

		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectionRequestTimeout(60000);
		httpRequestFactory.setConnectTimeout(60000);
		httpRequestFactory.setReadTimeout(60000);

		restTemplate.setRequestFactory(httpRequestFactory);

		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
			protected boolean hasError(HttpStatus statusCode) {
				return false;
			}
		});
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

		return restTemplate;

	}

}
