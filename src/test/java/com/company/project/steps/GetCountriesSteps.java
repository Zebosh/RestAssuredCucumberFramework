package com.company.project.steps;


import com.company.project.support.Country;
import com.company.project.utils.GetCountriesTestContext;
import com.company.project.utils.RestAssuredUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


public class GetCountriesSteps {
    @Inject
    private GetCountriesTestContext getCountriesContext;
    private static  final String HOST = "https://countriesnow.space/api/v0.1/";
    private static  final String PATH = "/all";


    @When("I get countries")
    public void iGetCountries() {
        Response response = RestAssuredUtil.sendGetRequest(HOST, PATH);
        getCountriesContext.setHttpResponse(response);


    }

    @Then("I verify (.*) exists in the response$")
    public void iVerifyVietnamExistsInTheResponse(String countryName) throws JsonProcessingException {
        List<Country> countries = Arrays.asList(getCountriesContext.getCountries());
        Optional<Country> countryoptional = countries.stream().filter(country -> country.getName().equals(countryName)).findFirst();
        assertTrue("country name with "+ countryName + " does not exist", countryoptional.isPresent());

    }

    @Then("I verify that status code is {int}")
    public void iVerifyThatStatusCodeIs(int statusCode) {
       assertEquals(statusCode, getCountriesContext.getHttpResponse().getStatusCode());
    }
}
