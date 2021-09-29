package com.assurity.test.qa.steps.common;

import com.assurity.test.qa.constants.EndPoints;
import com.assurity.test.qa.model.catagory.Catagory;
import com.assurity.test.qa.util.AuthorizeTokenGenerator;
import com.assurity.test.qa.util.CommonServiceUtils;
import com.assurity.test.qa.util.RestClient;
import com.assurity.test.qa.CucumberStepsDefinition;
import com.assurity.test.qa.model.CommonStorage;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Common Cucumber Steps.
 *
 * @author Jaliya Sumanadasa
 * <p>
 */

@CucumberStepsDefinition
public class CetelogueSteps {

    private static final Logger logger = Logger.getLogger(CetelogueSteps.class);

    @Autowired
    private RestClient client;

    @Autowired
    private CommonStorage commonStorage;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    CommonServiceUtils commonServiceUtils;

    private JsonNode catagoryNodeTree;

    @Autowired
    AuthorizeTokenGenerator authorizeTokenGenerator;

    @Value("${assurity.url}")
    private String domain;


    @When("^user send the request to get catalogue details with catagory code \"([^\"]*)\" having param \"([^\"]*)\" and value \"([^\"]*)\"$")
    public void userSendRequestToGetCaregoryDetailWithParams(String catagoryCode, String paramId, String paramValue) throws Throwable {

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(paramId, paramValue);

        loadCataloguePage(queryParams, catagoryCode);
        logger.info("Sent GET  Request: " + commonStorage.getResponseObject().getStatusCode());

    }

    @Then("^user should receive \"([^\"]*)\" as the response code$")
    public void user_should_receive_as_the_response_code(int expectedCode) throws Throwable {

        logger.info("Response Body:" + commonStorage.getResponseObject().getBody());
        Assert.assertEquals(expectedCode, commonStorage.getResponseObject().getStatusCode().value());
    }


    /**
     * check response displays expected value this will reduce defining more function for
     * every particulate attribute validation
     *
     * @param attribute note specifiy lower case to define the xpath
     *                  : JSON XPATH expected string value ex
     *                  e.g. root level - /name
     *                  siblings /promotions/
     * @param value     : expected value with in JSON attribute
     * @return
     * @throws Throwable
     */

    @Then("^user asserts catalogue attribute \"([^\"]*)\" equal text value of \"([^\"]*)\"$")
    public void userAssertCategoryResponceEqualByText(String attribute, String value) throws Throwable {

        Assert.assertEquals(value, catagoryNodeTree.at(attribute).asText().toString());

    }

    @Then("^user asserts catalogue attribute \"([^\"]*)\" contains text value of \"([^\"]*)\"$")
    public void userAssertCatagoryResponceContainsBytext(String attribute, String value) throws Throwable {

        Assert.assertTrue(catagoryNodeTree.at(attribute).asText().contains(value));

    }

    @Then("^user asserts catalogue attribute \"([^\"]*)\" equal boolean value of \"([^\"]*)\"$")
    public void userAssertCatagoryResponceEqualByBoolean(String attribute, boolean value) throws Throwable {

        Assert.assertEquals(value, catagoryNodeTree.at(attribute).booleanValue());

    }

    /**
     * check response displays expected value this will reduce defining more function for
     * every particulate attribute validation
     *
     * @param attribute(array Object) note -specifiy  attribute name in lower case
     *                        <p>
     *                        :      e.g. root level - /name
     *                        siblings /promotions/
     * @param attribute       xpath
     * @param value           expected value with in JSON attribute
     * @return
     * @throws Throwable
     */
    @Then("^user asserts catalogue of array object \"([^\"]*)\" of attribute \"([^\"]*)\" contain text value of \"([^\"]*)\"$")
    public void userAssertCatagoryResponceObjectContainsByText(String arrayObjectPath, String attributePath, String value) throws Throwable {

        List<Boolean> isFound = new ArrayList();

        List<String> list = new ArrayList<String>();
        catagoryNodeTree.at(arrayObjectPath).forEach(item -> {
            isFound.add(item.at(attributePath).asText().contains(value));

        });

        Assert.assertTrue(isFound.contains(true));

    }

    @Then("^user asserts catalogue of array object \"([^\"]*)\" of attribute \"([^\"]*)\" equal text value of \"([^\"]*)\"$")
    public void userAssertCatagoryResponceObjectEqualByText(String arrayObjectPath, String attributePath, String value) throws Throwable {

        List<String> list = new ArrayList<String>();
        catagoryNodeTree.at(arrayObjectPath).forEach(item -> {
            list.add(item.at(attributePath).asText());

        });

        Assert.assertTrue(list.contains(value));

    }

    /**
     * Load a catagory and store responce in node treee
     *
     * @param queryParam   : List of query parameters used
     * @param catagoryCode : catagory code need to be retrieve
     * @return Catagory Resource.
     * @throws Exception
     */

    private void loadCataloguePage(Map<String, String> queryParam, String catagoryCode) throws Throwable {

        String url = domain + EndPoints.TESTPATH.replace("#", catagoryCode);

       Map<String, String> headers = authorizeTokenGenerator.getCommonHeader();


        ResponseEntity<String> responseObject = client.getRequest(
                commonServiceUtils.setAPIHeaders(headers), url, new HashMap<String, String>(),
                queryParam);

        commonStorage.setResponseObject(responseObject);



        logger.info("response body - "+url+" - "+commonStorage.getResponseObject().getBody());

        /** store responce payload in node tree*/
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        Catagory catagory = objectMapper.readValue(commonStorage.getResponseObject().getBody(), Catagory.class);

        catagoryNodeTree = objectMapper.valueToTree(catagory);


    }


}
