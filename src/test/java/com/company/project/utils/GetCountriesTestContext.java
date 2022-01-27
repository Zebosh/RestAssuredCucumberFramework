package com.company.project.utils;

import com.company.project.support.Country;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Data;

@Data
@ScenarioScoped
public class GetCountriesTestContext {
    private Response httpResponse;

    private Country[] countries;

    public Country[] getCountries() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        countries = mapper.readValue(getHttpResponse().getBody().asString(), Country[].class);
        return countries;

    }
}
